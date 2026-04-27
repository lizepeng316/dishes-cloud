package com.etoak.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.etoak.common.core.excption.CustomException;
import com.etoak.entity.Ingredients;
import com.etoak.mapper.IngredientsMapper;
import com.etoak.service.IngredientsService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

@Service
public class IngredientsServiceImpl extends ServiceImpl<IngredientsMapper, Ingredients> implements IngredientsService {
    @Override
    public void add(Ingredients ingredients) {
        if(ObjectUtils.isNotEmpty(this.getByNames(ingredients.getName()))){
            throw new CustomException("食材已存在");
        }
        this.save(ingredients);
    }
    private Ingredients getByNames(String name){
        return lambdaQuery().eq(Ingredients::getName, name).one();
    }
}
