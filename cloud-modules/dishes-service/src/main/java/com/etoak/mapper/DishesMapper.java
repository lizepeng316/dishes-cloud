package com.etoak.mapper;

import com.etoak.entity.Dishes;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.etoak.vo.DishesVO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author etoak
 * @since 2026-04-28
 */
public interface DishesMapper extends BaseMapper<Dishes> {

    List<DishesVO> getList(Dishes dishes);
}
