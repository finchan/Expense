package com.xavier.expense.controller;

import com.xavier.expense.model.Category;
import com.xavier.expense.model.DailyCost;
import com.xavier.expense.service.ICategoryService;
import com.xavier.expense.service.IDailyCostService;
import com.xavier.expense.util.PageNavigationPath;
import com.xavier.expense.util.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
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

    public List<Category> getAllCategories() {
        return categoryService.getAllCategories( );
    }

    public List<Category> getAllSubCategories() {
        return categoryService.getAllSubCategories( );
    }

    @RequestMapping(value=PageNavigationPath.ROOT)
    public String gotoHomePage(Model model ) {
        model.addAttribute("cost", new DailyCost());
        return "redirect:" + PageNavigationPath.HOMEPAGE;
    }

    @RequestMapping(value=PageNavigationPath.HOMEPAGE)
    public String displayMonthlyExpense(Model model) {
        //1. Get All Categories
        List<Category> categories = getAllCategories( );
        model.addAttribute("categories", categories);

        //2. Get All Sub-Categories
        List<Category> subCategories = getAllSubCategories( );
        model.addAttribute("subCategories", subCategories);

        DailyCost cost = new DailyCost( );
        String today = Utilities.getDateYYYYMMDD("YYYY-MM-dd", new Date( ));
        cost.setDate(today);
        model.addAttribute("cost", cost);
        model.addAttribute("initializeFlag", true);

        return PageNavigationPath.DISPLAYTODAYSEXPENSE;
    }

    @RequestMapping (value=PageNavigationPath.GETMONTHLYDATA, method = RequestMethod.POST)
    public @ResponseBody List<DailyCost> getMonthlyData (DailyCost cost) {
        List<DailyCost> dailyCostList =  dailyCostService.getMonthlyData(cost);
        return dailyCostList;
    }
}
