package com.etoak.controller;


import com.etoak.common.core.vo.PageVO;
import com.etoak.common.core.vo.ResultVO;
import com.etoak.entity.Dishes;
import com.etoak.service.DishesService;
import com.etoak.vo.DishesVO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *  前端控制器
 * @author etoak
 * @since 2026-04-28
 */
@RestController
@RequestMapping("/dishes")
public class DishesController {

    DishesService dishesService;

    public DishesController(DishesService dishesService) {
        this.dishesService = dishesService;
    }

    @PostMapping
    public ResultVO<Object> add(@Valid @RequestBody Dishes dishes){
        dishesService.add(dishes);
        return ResultVO.success();
    }

    @GetMapping("/list")
    public ResultVO<PageVO<DishesVO>> list(
            @RequestParam(defaultValue = "1", required = false) Integer pageNum,
            @RequestParam(defaultValue = "10", required = false) Integer pageSize,
            Dishes dishes
    ){
        PageVO<DishesVO> pageVO = dishesService.listpage(pageNum, pageSize, dishes);
        return ResultVO.success(pageVO);
    }

    @PostMapping("/{id}")
    public ResultVO<Object> update(@PathVariable Integer id,@RequestBody Dishes dishes){

        dishesService.update(id,dishes);
        return ResultVO.success();
    }

    @PostMapping("/delete")
    public ResultVO<Object> delete( int id){
        dishesService.delete(id);
        return ResultVO.success();
    }
}

