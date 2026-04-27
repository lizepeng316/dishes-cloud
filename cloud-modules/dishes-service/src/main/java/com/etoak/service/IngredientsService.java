package com.etoak.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.etoak.common.core.vo.PageVO;
import com.etoak.entity.Ingredients;

import java.util.List;

public interface IngredientsService extends IService<Ingredients> {

    /**
     * 添加食材
     *
     * @param ingredients 食材信息
     */
    void add(Ingredients ingredients);

    /**
     * 分页查询食材列表
     *
     * @param pageNum     页码
     * @param pageSize    每页数量
     * @param ingredients 查询参数
     */
    PageVO<Ingredients> pageList(Integer pageNum, Integer pageSize, Ingredients ingredients);

    /**
     * 查询食材列表
     *
     * @param ingredients 查询参数
     */
    List<Ingredients> getList(Ingredients ingredients);
}
