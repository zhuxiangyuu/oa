package com.example.oa.po;

import java.util.Date;

/**
 * 会议室预定表
 */
public class RoomReserve {

    private Integer id;

    private Integer roomid;  // 会议室ID

    private Room room;

    private Date starttime;// 起始时间

    private Date endtime;// 结束时间

    private Integer type;// 会议室用途类型  （1：会议 2：面试 3：培训 4：会客 5：其他）

    private Integer userid;// 预订人

    private User user;

    private Integer adminid;// 批准人

    private User admin;

    private Integer state;// 审核状态 (1.待审核(审核中) 2.审核通过 3.审核不通过 4.已过期)

    public Integer getId() {
        return id;
    }

    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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
}