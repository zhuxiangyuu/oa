package com.example.oa.po;

/**
 * 机构表
 */
public class Organization {

    private Integer id;

    private String name; // 机构名称

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