package com.xavier.expense.model;

/**
 * Created by Xavier on 2016-01-24.
 */
public class Category {
    private Integer id;
    private String name;
    private Integer parentId;

    public Category() {

    }

    public Category(Integer id, String name, Integer parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public Category(String name, Integer parentId) {
        this.name = name;
        this.parentId = parentId;
    }

    public Category(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
