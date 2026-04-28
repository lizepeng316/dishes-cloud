package com.etoak.service;

import com.etoak.entity.Dishes;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.validation.Valid;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author etoak
 * @since 2026-04-28
 */
public interface DishesService extends IService<Dishes> {

    /**
     * 添加菜品
     * @param dishes 菜品
     */
    void add(Dishes dishes);
}
