package platform.jizhang.biu.service.model;

import java.math.BigDecimal;

public class ConsumeJoinVO {
    private Integer id;

    private Integer recordId;

    private Integer payUserId;

    private BigDecimal costMount;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getPayUserId() {
        return payUserId;
    }

    public void setPayUserId(Integer payUserId) {
        this.payUserId = payUserId;
    }

    public BigDecimal getCostMount() {
        return costMount;
    }

    public void setCostMount(BigDecimal costMount) {
        this.costMount = costMount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}