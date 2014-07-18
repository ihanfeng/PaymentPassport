package com.cssweb.distributedsession;

import java.math.BigDecimal;

/**
 * Created by chenhf on 2014/7/10.
 */
public class Account {
    private long accountId;
    private String Name;
    private BigDecimal available;

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public BigDecimal getAvailable() {
        return available;
    }

    public void setAvailable(BigDecimal available) {
        this.available = available;
    }
}
