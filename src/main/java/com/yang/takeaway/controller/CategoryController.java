package com.yang.takeaway.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yang.takeaway.common.Res;
import com.yang.takeaway.entity.Category;
import com.yang.takeaway.service.CategoryService;
import com.yang.takeaway.service.impl.CategoryServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryServiceimpl;

    /**
     * 新增分类
     * @param category
     * @return
     */
    @PostMapping
    public Res<String> save(@RequestBody Category category){
        log.info("category:{}",category);
        categoryServiceimpl.save(category);
        return Res.success("新增分类成功");
    }

    /**
     *分页查询
     */
    @GetMapping("/page")
    public Res<Page> page(int page,int pageSize){
        Page<Category> pageInfo = new Page<>(page,pageSize);
        //条件构造器
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        //添加排序条件，根据sort进行排序
        queryWrapper.orderByAsc(Category::getSort);

        //分页查询
        categoryServiceimpl.page(pageInfo,queryWrapper);
        return Res.success(pageInfo);
    }
    /**
     * 根据id删除分类
     * @param id
     * @return
     */
    @DeleteMapping
    public Res<String> delete(Long id){
        log.info("删除分类，id为：{}",id);

        //categoryService.removeById(id);
        categoryServiceimpl.remove(id);

        return Res.success("分类信息删除成功");
    }

    /**
     * 根据id修改分类信息
     * @param category
     * @return
     */
    @PutMapping
    public Res<String> update(@RequestBody Category category){
        log.info("修改分类信息：{}",category);

        categoryServiceimpl.updateById(category);

        return Res.success("修改分类信息成功");
    }
    /**
     * 根据条件查询分类数据
     * @param category
     * @return
     */
    @GetMapping("/list")
    public Res<List<Category>> list(Category category){
        //条件构造器
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        //添加条件
        queryWrapper.eq(category.getType() != null,Category::getType,category.getType());
        //添加排序条件
        queryWrapper.orderByAsc(Category::getSort).orderByDesc(Category::getUpdateTime);

        List<Category> list = categoryServiceimpl.list(queryWrapper);
        return Res.success(list);
    }

}
