package com.etoak.service.impl;


import com.etoak.common.core.excption.CustomException;
import com.etoak.common.core.vo.PageVO;
import com.etoak.entity.Dishes;
import com.etoak.mapper.DishesMapper;
import com.etoak.service.DishesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.etoak.vo.DishesVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author etoak
 * @since 2026-04-28
 */
@Service
public class DishesServiceImpl extends ServiceImpl<DishesMapper, Dishes> implements DishesService {

    @Override
    public void add(Dishes dishes) {
        if (ObjectUtils.isNotEmpty(this.getByName(dishes.getName()))){
            throw new CustomException("菜品已存在");
        }
        this.save(dishes);
    }

    @Override
    public PageVO<DishesVO> listpage(Integer pageNum, Integer pageSize, Dishes dishes) {
        PageHelper.startPage(pageNum, pageSize);
        List<DishesVO> dishesVOList = this.baseMapper.getList(dishes);
        return new PageVO<>(new PageInfo<>(dishesVOList).getTotal(), dishesVOList);
    }

    @Override
    public void update(Integer id, Dishes dishes) {
        if (ObjectUtils.isEmpty(this.getById(id))){
            throw new CustomException("菜品不存在");
        }

        String name = dishes.getName();
        if(StringUtils.isNotEmpty( name)){
            Dishes savedDishes = this.getByName(name);
            if (ObjectUtils.isNotEmpty(savedDishes) && !savedDishes.getId().equals(id)){
                throw new CustomException("菜品已存在");
            }
        }
        dishes.setId(id);
        this.updateById(dishes);
    }

    @Override
    public void delete(int id) {
        if (ObjectUtils.isEmpty(this.getById(id))){
            throw new CustomException("菜品不存在");
        }
        this.removeById(id);
    }

    private Dishes getByName(String name) {
        return lambdaQuery()
                .eq(Dishes::getName, name)
                .one();
    }
}
