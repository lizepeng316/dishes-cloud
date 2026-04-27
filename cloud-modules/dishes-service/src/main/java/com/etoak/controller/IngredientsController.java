package com.etoak.controller;

import com.etoak.common.core.vo.ResultVO;
import com.etoak.entity.Ingredients;
import com.etoak.service.IngredientsService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {

    IngredientsService ingredientsService;

    public IngredientsController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @PostMapping("/add")
    public ResultVO<Object> add(@Valid @RequestBody Ingredients ingredients){
        ingredientsService.add(ingredients);
        return ResultVO.success();
    }
}
