package com.etoak.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.etoak.common.core.excption.CustomException;
import com.etoak.common.core.vo.PageVO;
import com.etoak.entity.Ingredients;
import com.etoak.mapper.IngredientsMapper;
import com.etoak.service.IngredientsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public PageVO<Ingredients> pageList(Integer pageNum, Integer pageSize, Ingredients ingredients) {
        PageHelper.startPage(pageNum, pageSize);
        List<Ingredients> list = this.getList(ingredients);
        return new PageVO<>(new PageInfo<>(list).getTotal(), list);
    }

    @Override
    public List<Ingredients> getList(Ingredients ingredients) {
        return lambdaQuery()
                .likeRight(StringUtils.isNotEmpty(ingredients.getName()),Ingredients::getName, ingredients.getName())
                .eq(StringUtils.isNotEmpty(ingredients.getType()),Ingredients::getType, ingredients.getType())
                .list();
    }

    @Override
    public void update(Integer id, Ingredients ingredients) {
        if (ObjectUtils.isEmpty(this.getById(id))){
            throw new CustomException("食材不存在");
        }
        String name = ingredients.getName();
        if (StringUtils.isNotEmpty(name)){
            Ingredients saveIngredients = this.getByNames(name);
            if (ObjectUtils.isNotEmpty(saveIngredients) && !saveIngredients.getId().equals(id)){
                throw new CustomException("不能修改为其他食材的名称");
            }
        }
        ingredients.setId(id);
        this.updateById(ingredients);
    }

    @Override
    public void delete(int id) {
        if (ObjectUtils.isEmpty(this.getById(id))){
            throw new CustomException("食材不存在");
        }

        this.removeById(id);
    }

}
