package com.xavier.expense.service.impl;

import com.xavier.expense.dao.ICategoryDAO;
import com.xavier.expense.model.Category;
import com.xavier.expense.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Xavier on 2016-01-24.
 */

@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService{
    @Autowired
    private ICategoryDAO categoryDAO;

    public List<Category> getAllCategories( ) {
        return categoryDAO.getAllCategories( );
    }

    public List<Category> getAllSubCategories( ) {
        return categoryDAO.getAllSubCategories( );
    }

    //    public List<Category> getCategoryList(Category category) {
//        return categoryDAO.getCategoryList(category);
//    }
//
//    public List<Category> getSubCategoryList(Category category) {
//        return null;
//    }


}
