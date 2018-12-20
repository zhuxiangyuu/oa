package com.example.oa.common;

import java.util.List;

public class Children {
    private int id;
    private String text;
    private String href;
    private int type;
    private List<Children> children;

    public Children() {}

    public Children(int id, String text, String href, int type) {
        this.id = id;
        this.text = text;
        this.href = href;
        this.type = type;
    }

    public Children(int id, String text, String href, int type, List<Children> children) {
        this.id = id;
        this.text = text;
        this.href = href;
        this.type = type;
        this.children = children;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }
}
