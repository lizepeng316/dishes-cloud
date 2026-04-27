package com.etoak.common.web.handler;

import com.etoak.common.core.excption.CustomException;
import com.etoak.common.core.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/**
 * 全局异常处理
 *
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandle {
    /**
    * 自定义异常处理
    */
   @ExceptionHandler
    public ResultVO<Object> handle(CustomException e){
       log.error(e.getMessage(),e);
       return ResultVO.failed(e.getMessage());
   }
   /**
    * 参数校验异常
    */
   @ExceptionHandler
    public ResultVO<Object> handle(MethodArgumentNotValidException e){
       log.error(e.getMessage(),e);
       String message = e.getAllErrors().stream().map(ObjectError::getDefaultMessage)
               .collect(Collectors.joining(";"));
       return ResultVO.failed(message);
   }
   /**
    * 请求方法错误
    */
   @ExceptionHandler
    public ResultVO<Object> handle(HttpRequestMethodNotSupportedException e){
       log.error(e.getMessage(),e);
       return ResultVO.failed("Http 请求方法错误");
   }
   /**
    * 请求参数类型错误
    */
   @ExceptionHandler
    public ResultVO<Object> handle(HttpMediaTypeNotSupportedException e){
       log.error(e.getMessage(),e);
       return ResultVO.failed("Http 请求参数类型错误");
   }
   /**
    * 默认异常处理
    */
   @ExceptionHandler
    public ResultVO<Object> handle(Exception e){
       log.error(e.getMessage(),e);
       return ResultVO.failed("系统异常");
   }
}
