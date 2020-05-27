package com.management.entity;

import java.util.Date;

public class Liuyan {
    private Integer id;
    private Integer ownerId;
    private Integer leaveId;
    private String leaveUserName;
    private Date date;
    private String content;
    private String postTitle;

    @Override
    public String toString() {
        return "Liuyan{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", leaveId=" + leaveId +
                ", leaveUserName='" + leaveUserName + '\'' +
                ", date=" + date +
                ", content='" + content + '\'' +
                ", postTitle='" + postTitle + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Integer leaveId) {
        this.leaveId = leaveId;
    }

    public String getLeaveUserName() {
        return leaveUserName;
    }

    public void setLeaveUserName(String leaveUserName) {
        this.leaveUserName = leaveUserName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }
}
