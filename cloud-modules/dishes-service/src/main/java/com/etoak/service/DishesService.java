package com.etoak.service;

import com.etoak.common.core.vo.PageVO;
import com.etoak.entity.Dishes;
import com.baomidou.mybatisplus.extension.service.IService;
import com.etoak.vo.DishesVO;
import jakarta.validation.Valid;

import java.util.List;

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

    PageVO<DishesVO> listpage(Integer pageNum, Integer pageSize, Dishes dishes);


    void update(Integer id, Dishes dishes);

    void delete(int id);
}
