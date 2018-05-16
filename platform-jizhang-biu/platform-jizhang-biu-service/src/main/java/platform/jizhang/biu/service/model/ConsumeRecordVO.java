package platform.jizhang.biu.service.model;

import java.math.BigDecimal;
import java.util.Date;

public class ConsumeRecordVO {
    private Integer id;

    private String consumeTitle;

    private String consumeAddress;

    private Integer consumeType;

    private Integer handlerType;

    private Integer payUserId;

    private Integer groupId;

    private BigDecimal price;

    private Date consmueTime;

    private Integer status;

    private Date handlerTime;

    private String picAddress1;

    private String picAddress2;

    private String consumeDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConsumeTitle() {
        return consumeTitle;
    }

    public void setConsumeTitle(String consumeTitle) {
        this.consumeTitle = consumeTitle == null ? null : consumeTitle.trim();
    }

    public String getConsumeAddress() {
        return consumeAddress;
    }

    public void setConsumeAddress(String consumeAddress) {
        this.consumeAddress = consumeAddress == null ? null : consumeAddress.trim();
    }

    public Integer getConsumeType() {
        return consumeType;
    }

    public void setConsumeType(Integer consumeType) {
        this.consumeType = consumeType;
    }

    public Integer getHandlerType() {
        return handlerType;
    }

    public void setHandlerType(Integer handlerType) {
        this.handlerType = handlerType;
    }

    public Integer getPayUserId() {
        return payUserId;
    }

    public void setPayUserId(Integer payUserId) {
        this.payUserId = payUserId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getConsmueTime() {
        return consmueTime;
    }

    public void setConsmueTime(Date consmueTime) {
        this.consmueTime = consmueTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getHandlerTime() {
        return handlerTime;
    }

    public void setHandlerTime(Date handlerTime) {
        this.handlerTime = handlerTime;
    }

    public String getPicAddress1() {
        return picAddress1;
    }

    public void setPicAddress1(String picAddress1) {
        this.picAddress1 = picAddress1 == null ? null : picAddress1.trim();
    }

    public String getPicAddress2() {
        return picAddress2;
    }

    public void setPicAddress2(String picAddress2) {
        this.picAddress2 = picAddress2 == null ? null : picAddress2.trim();
    }

    public String getConsumeDesc() {
        return consumeDesc;
    }

    public void setConsumeDesc(String consumeDesc) {
        this.consumeDesc = consumeDesc == null ? null : consumeDesc.trim();
    }
}