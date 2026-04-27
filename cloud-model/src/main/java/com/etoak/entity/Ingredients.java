package com.etoak.entity;

import com.baomidou.mybatisplus.annotation.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@TableName("t_ingredients")
public class Ingredients {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    @NotBlank(message = "name不能为空")
    private String name;

    /**
     * 类型
     */
    @NotBlank(message = "type不能为空")
    @DecimalMin(value = "1", message = "type不能小于1")
    @DecimalMax(value = "3", message = "type不能大于3")
    private String type;

    /**
     * 食材图片
     */
    @NotBlank(message = "url不能为空")
    private String url;

    /**
     * 备注
     */
    @NotBlank(message = "remark不能为空")
    private String remark;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private String createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private String updateTime;
}
