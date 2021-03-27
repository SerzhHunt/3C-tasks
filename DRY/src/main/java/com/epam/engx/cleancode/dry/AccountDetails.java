package com.epam.engx.cleancode.dry;

import com.epam.engx.cleancode.dry.thirdpartyjar.Account;

import java.math.BigDecimal;
import java.util.Date;

public class AccountDetails implements Account {
    private final Date birth;
    private final int age;
    private BigDecimal balance;
    private Date startDate;

    public AccountDetails(Date birth, int age, BigDecimal balance, Date startDate) {
        this.birth = birth;
        this.age = age;
        this.balance = balance;
        this.startDate = startDate;
    }

    @Override
    public Date getBirth() {
        return birth;
    }
    @Override
    public Date getStartDate() {
        return startDate;
    }

    @Override
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    public int getAge() {
        return age;       // should depend on current time
    }
}
