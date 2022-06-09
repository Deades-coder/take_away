package com.yang.takeaway.dto;

import com.yang.takeaway.entity.Dish;
import com.yang.takeaway.entity.DishFlavor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class DishDto extends Dish {

    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
