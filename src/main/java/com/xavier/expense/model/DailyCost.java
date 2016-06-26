package com.xavier.expense.model;

import java.math.BigDecimal;

/**
 * Created by Xavier on 2016-01-24.
 */
public class DailyCost {
    private Integer id;
    private String date;
    private String startDate;
    private String endDate;
    private Category category;
    private Category subCategory;
    private String description;
    private BigDecimal amount;

    public DailyCost( ) {

    }

    public DailyCost(Integer id, String date, String startDate, String endDate, Category category, Category subCategory, String description, BigDecimal amount) {
        this.id = id;
        this.date = date;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
        this.subCategory = subCategory;
        this.description = description;
        this.amount = amount;
    }

    public DailyCost(Integer id, String startDate, String endDate, Category category, Category subCategory, String description, BigDecimal amount) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
        this.subCategory = subCategory;
        this.description = description;
        this.amount = amount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public DailyCost(Integer id, String date, Category category, Category subCategory, String description, BigDecimal amount) {
        this.id = id;
        this.date = date;
        this.category = category;
        this.description = description;
        this.amount = amount;
    }

    public DailyCost(String date, Category category, String description, BigDecimal amount) {
        this.date = date;
        this.category = category;
        this.description = description;
        this.amount = amount;
    }

    public DailyCost(String date, Category category, BigDecimal amount) {
        this.date = date;
        this.category = category;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(Category subCategory) {
        this.subCategory = subCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
