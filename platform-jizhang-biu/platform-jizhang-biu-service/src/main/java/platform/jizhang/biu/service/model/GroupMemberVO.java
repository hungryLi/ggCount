package platform.jizhang.biu.service.model;

import java.util.Date;

public class GroupMemberVO {
    private Integer id;

    private Integer groupId;

    private Integer userId;

    private String userName;

    private Integer status;

    private String refuseReson;

    private Date regTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRefuseReson() {
        return refuseReson;
    }

    public void setRefuseReson(String refuseReson) {
        this.refuseReson = refuseReson == null ? null : refuseReson.trim();
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }
}