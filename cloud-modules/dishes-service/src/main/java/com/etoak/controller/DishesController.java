package com.etoak.controller;


import com.etoak.common.core.vo.ResultVO;
import com.etoak.entity.Dishes;
import com.etoak.service.DishesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
}

