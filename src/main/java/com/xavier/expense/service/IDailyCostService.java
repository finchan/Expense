package com.xavier.expense.service;

import com.xavier.expense.model.DailyCost;

import java.util.List;

/**
 * Created by Xavier on 2016-02-08.
 */
public interface IDailyCostService {
    public List<DailyCost> getMonthlyData (DailyCost cost);
}
