package com.example.oa.po;

/**
 * 部门表
 */
public class Dept {

    private Integer id;

    private String name; // 部门名称

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
        this.name = name == null ? null : name.trim();
    }
}