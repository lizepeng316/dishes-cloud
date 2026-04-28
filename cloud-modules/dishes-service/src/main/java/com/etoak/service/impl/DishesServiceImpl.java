package com.etoak.service.impl;


import com.etoak.common.core.excption.CustomException;
import com.etoak.entity.Dishes;
import com.etoak.mapper.DishesMapper;
import com.etoak.service.DishesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

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

    private Dishes getByName(String name) {
        return lambdaQuery()
                .eq(Dishes::getName, name)
                .one();
    }
}
