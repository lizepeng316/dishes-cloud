package com.etoak.vo;

import com.etoak.entity.Dishes;
import lombok.Data;

@Data
public class DishesVO extends Dishes {
    private String mainName;

    private String minorName;

    private String seasoningName;
}
