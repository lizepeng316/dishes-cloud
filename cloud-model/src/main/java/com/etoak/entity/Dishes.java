package com.etoak.entity;

import com.baomidou.mybatisplus.annotation.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@TableName("t_dishes")
public class Dishes {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @NotBlank(message = "name不能为空")
    private String name;

    @NotBlank(message = "url不能为空")
    private String url;

    @NotNull(message = "main不能为空")
    private Integer main;

    @NotNull(message = "mainNum不能为空")
    private Integer mainNum;

    @NotNull(message = "minor不能为空")
    private Integer minor;

    @NotNull(message = "minorNum不能为空")
    private Integer minorNum;

    @NotNull(message = "seasoning不能为空")
    private Integer seasoning;

    @NotNull(message = "seasoningNum不能为空")
    private Integer seasoningNum;

    @NotBlank(message = "remark不能为空")
    private String remark;

    @TableField(fill = FieldFill.INSERT)
    private String createTime;

    @TableField(fill = FieldFill.UPDATE)
    private String updateTime;
}
