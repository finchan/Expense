package com.xavier.expense.dao;

import com.xavier.expense.model.Category;

import java.util.List;

/**
 * Created by Xavier on 2016-01-24.
 */
public interface ICategoryDAO {
    public List<Category> getAllCategories();
    public List<Category> getAllSubCategories( );
//    public List<Category> getCategoryList(Category category);
//    public List<Category> getSubCategoryList(Category category);
}
