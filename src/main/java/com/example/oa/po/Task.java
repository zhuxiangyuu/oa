package com.example.oa.po;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 任务表
 */
public class Task {
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date time1;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date time2;

    private Integer id;

    private Integer type;// 任务类型
    // (1.会议室管理 2.用户车管理 3.用章管理 4.图书借阅申请 5.名片印制流程 6.请假申请 7.出差申请 8.收入证明流程 )

    private Integer taskid;// 任务编号( 任务类型+你任务的ID）

    private String name;// 任务名称（用户名称+某某申请）

    private Integer userid;// 任务申请人

    private User user;

    private Integer adminid;// 任务审核人

    private User admin;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date starttime;// 发起时间
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date subtime;// 审核时间

    private Integer state;// 审核状态 (1.待审核(审核中) 2.审核通过 3.审核不通过)

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getSubtime() {
        return subtime;
    }

    public void setSubtime(Date subtime) {
        this.subtime = subtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public Date getTime1() {
        return time1;
    }

    public void setTime1(Date time1) {
        this.time1 = time1;
    }

    public Date getTime2() {
        return time2;
    }

    public void setTime2(Date time2) {
        this.time2 = time2;
    }
}