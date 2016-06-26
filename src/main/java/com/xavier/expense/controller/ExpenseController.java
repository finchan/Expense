package com.xavier.expense.controller;

import com.xavier.expense.model.Category;
import com.xavier.expense.model.DailyCost;
import com.xavier.expense.service.ICategoryService;
import com.xavier.expense.service.IDailyCostService;
import com.xavier.expense.util.PageNavigationPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Xavier on 01/17/2016.
 */
@Controller
public class ExpenseController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IDailyCostService dailyCostService;


    @RequestMapping(value="/")
    public String gotoHomePage(Model model ) {
        model.addAttribute("cost", new DailyCost());
        return PageNavigationPath.HOMEPAGE;
    }

    @RequestMapping(value="/management/display")
    public String displayMonthlyExpense(Model model) {
        //1. Get All Categories
        List<Category> categories = getAllCategories( );
        model.addAttribute("categories", categories);

        //2. Get All Sub-Categories
        List<Category> subCategories = getAllSubCategories( );
        model.addAttribute("subCategories", subCategories);
        model.addAttribute("cost", new DailyCost());

        return "management/display";
    }

    @RequestMapping (value="/management/getMonthlyData", method = RequestMethod.POST)
    public @ResponseBody List<DailyCost> getMonthlyData (DailyCost cost ) {
        List<DailyCost> dailyCostList =  dailyCostService.getMonthlyData(cost);
        return dailyCostList;
    }

    public List<Category> getAllCategories() {
        return categoryService.getAllCategories( );
    }

    public List<Category> getAllSubCategories() {
        return categoryService.getAllSubCategories( );
    }


}
