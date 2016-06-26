package com.xavier.expense.dao;

import com.xavier.expense.model.DailyCost;

import java.util.List;

/**
 * Created by Xavier on 2016-02-08.
 */
public interface IDailyCostDAO {
    public List<DailyCost> getMonthlyData(DailyCost cost);
}
