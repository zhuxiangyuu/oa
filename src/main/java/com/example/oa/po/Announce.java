package com.example.oa.po;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 通告表
 */
public class Announce {

    private Integer id;

    private String title; // 标题

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date starttime; // 开始时间
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date endtime;// 结束时间
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date subtime;// 发布时间

    private Integer userid;//发布人

    private User user;

    private Task task;

    private Integer adminid;  // 审批人

    private User admin;

    private String content;// 内容

    //private Integer state; // 状态  (1：草稿 2：已发布  3：已过期)


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getSubtime() {
        return subtime;
    }

    public void setSubtime(Date subtime) {
        this.subtime = subtime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

/*  public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }*/

}