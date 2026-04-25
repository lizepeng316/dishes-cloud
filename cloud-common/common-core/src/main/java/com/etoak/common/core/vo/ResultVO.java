package com.etoak.common.core.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * REST 接口返回值
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO<T> {

    /**
     * 成功响应码
     */
    public static final int SUCCESS_CODE = 200;

    /**
     * 成功响应消息
     */
    public static final String SUCCESS_MESSAGE = "success";

    public static final int FAILED_CODE = 500;

    public static final String FAILED_MESSAGE = "服务器内部错误！";

    /**
     * 拒绝访问
     */
    public static final int FORBIDDEN_CODE = 403;

    private Integer code;

    private String message;

    private T data;

    public static <T> ResultVO<T> success() {
        return success(null);
    }

    public static <T> ResultVO<T> success(T data) {
        return new ResultVO<>(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    /**
     * {code = 500, message = "服务器内部错误！"}
     */
    public static <T> ResultVO<T> failed() {
        return failed(FAILED_MESSAGE);
    }

    public static <T> ResultVO<T> failed(String message) {
        return failed(FAILED_CODE, message);
    }

    public static <T> ResultVO<T> failed(int code, String message) {
        return new ResultVO<>(code, message, null);
    }
}