package com.cssweb.distributedsession;

import java.math.BigDecimal;

/**
 * Created by chenhf on 2014/7/10.
 */
public class Account {
    private long accountId;
    private String accountName;
    private BigDecimal available;

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public BigDecimal getAvailable() {
        return available;
    }

    public void setAvailable(BigDecimal available) {
        this.available = available;
    }
}
