package platform.jizhang.biu.service.model;

import java.math.BigDecimal;
import java.util.Date;

public class AccountInfoVO {
    private Long accountId;

    private String accountCode;

    private Integer userId;

    private BigDecimal balance;

    private BigDecimal dividend;

    private BigDecimal cumuDividend;

    private String extractPwd;

    private String currencyName;

    private Integer currencyId;

    private String accountName;

    private Long operatorId;

    private Long agentId;

    private BigDecimal integralValue;

    private BigDecimal totalRecharge;

    private BigDecimal ibcSportMin;

    private BigDecimal ibcSportMax;

    private BigDecimal totalAmount;

    private Integer type;
    
    private Date createTime;
    
    private BigDecimal bond;
    
    private BigDecimal bondBalance;
    
    private Double bondRate;
    
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode == null ? null : accountCode.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getDividend() {
        return dividend;
    }

    public void setDividend(BigDecimal dividend) {
        this.dividend = dividend;
    }

    public BigDecimal getCumuDividend() {
        return cumuDividend;
    }

    public void setCumuDividend(BigDecimal cumuDividend) {
        this.cumuDividend = cumuDividend;
    }

    public String getExtractPwd() {
        return extractPwd;
    }

    public void setExtractPwd(String extractPwd) {
        this.extractPwd = extractPwd == null ? null : extractPwd.trim();
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName == null ? null : currencyName.trim();
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Long getAgentId() {
        return agentId;
    }

    public void setAgentId(Long agentId) {
        this.agentId = agentId;
    }

    public BigDecimal getIntegralValue() {
        return integralValue;
    }

    public void setIntegralValue(BigDecimal integralValue) {
        this.integralValue = integralValue;
    }

    public BigDecimal getTotalRecharge() {
        return totalRecharge;
    }

    public void setTotalRecharge(BigDecimal totalRecharge) {
        this.totalRecharge = totalRecharge;
    }

    public BigDecimal getIbcSportMin() {
        return ibcSportMin;
    }

    public void setIbcSportMin(BigDecimal ibcSportMin) {
        this.ibcSportMin = ibcSportMin;
    }

    public BigDecimal getIbcSportMax() {
        return ibcSportMax;
    }

    public void setIbcSportMax(BigDecimal ibcSportMax) {
        this.ibcSportMax = ibcSportMax;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public BigDecimal getBond() {
		return bond;
	}

	public void setBond(BigDecimal bond) {
		this.bond = bond;
	}

	public BigDecimal getBondBalance() {
		return bondBalance;
	}

	public void setBondBalance(BigDecimal bondBalance) {
		this.bondBalance = bondBalance;
	}

	public Double getBondRate() {
		return bondRate;
	}

	public void setBondRate(Double bondRate) {
		this.bondRate = bondRate;
	}
    
}