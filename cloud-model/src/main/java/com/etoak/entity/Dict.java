package com.etoak.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_dict")
public class Dict {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 数据字典类型
     */
    private String type;

    /**
     * 数据字典标签
     */
    private String label;

    /**
     * 数据字典值
     */
    private String value;

    /**
     * 排序
     */
    private Integer sort;
}
