package com.yang.takeaway.dto;

import com.yang.takeaway.entity.Setmeal;
import com.yang.takeaway.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
