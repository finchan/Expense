package com.xavier.expense.service.impl;

import com.xavier.expense.dao.IDailyCostDAO;
import com.xavier.expense.model.DailyCost;
import com.xavier.expense.service.IDailyCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Xavier on 2016-02-08.
 */
@Service("dailyCostService")
public class DailyCostServiceImpl implements IDailyCostService{
    @Autowired
    private IDailyCostDAO dailyCostDAO;

    public List<DailyCost> getMonthlyData(DailyCost cost) {
        return dailyCostDAO.getMonthlyData(cost);
    }
}
