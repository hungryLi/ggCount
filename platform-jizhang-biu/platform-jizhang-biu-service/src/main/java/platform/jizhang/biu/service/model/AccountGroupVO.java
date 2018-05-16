package platform.jizhang.biu.service.model;

import java.util.Date;

public class AccountGroupVO {
    private Integer groupId;

    private String groupName;

    private String groupSign;

    private String groupIcon;

    private Integer createUserId;

    private Integer status;

    private Date createTime;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getGroupSign() {
        return groupSign;
    }

    public void setGroupSign(String groupSign) {
        this.groupSign = groupSign == null ? null : groupSign.trim();
    }

    public String getGroupIcon() {
        return groupIcon;
    }

    public void setGroupIcon(String groupIcon) {
        this.groupIcon = groupIcon == null ? null : groupIcon.trim();
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}