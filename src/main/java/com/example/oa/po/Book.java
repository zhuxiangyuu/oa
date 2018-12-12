package com.example.oa.po;

/**
 * 图书表
 */
public class Book {

    private String bookid;// 图书ID

    private String name;// 图书名称

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid == null ? null : bookid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}