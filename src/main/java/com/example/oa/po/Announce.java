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

    private String content;// 内容

    private Integer state; // 状态  (1：草稿 2：已发布  3：已过期)


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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Announce{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", subtime=" + subtime +
                ", userid=" + userid +
                ", user=" + user +
                ", content='" + content + '\'' +
                ", state=" + state +
                '}';
    }
}