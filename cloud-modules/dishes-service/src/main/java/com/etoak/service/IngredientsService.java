package com.etoak.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.etoak.entity.Ingredients;

public interface IngredientsService extends IService<Ingredients> {

    void add(Ingredients ingredients);
}
