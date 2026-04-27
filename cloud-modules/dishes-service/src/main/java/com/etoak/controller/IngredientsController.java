package com.etoak.controller;

import com.etoak.common.core.vo.PageVO;
import com.etoak.common.core.vo.ResultVO;
import com.etoak.entity.Ingredients;
import com.etoak.service.IngredientsService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/list")
    public ResultVO<PageVO<Ingredients>> list(
            @RequestParam(defaultValue = "1", required = false) Integer pageNum,
            @RequestParam(defaultValue = "10", required = false) Integer pageSize,
            Ingredients ingredients){

        PageVO<Ingredients> pageVO = ingredientsService.pageList(pageNum, pageSize, ingredients);
        return ResultVO.success(pageVO);
    }
}
