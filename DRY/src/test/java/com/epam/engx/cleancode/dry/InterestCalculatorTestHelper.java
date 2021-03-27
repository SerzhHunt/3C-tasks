package com.epam.engx.cleancode.dry;

import com.epam.engx.cleancode.dry.thirdpartyjar.Account;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class InterestCalculatorTestHelper {

    public static Account makeAccountDetails(double balance, int age, int startedYearsAgo) {
        return new AccountDetails(getCurrentDateMinusYears(age),age,
                BigDecimal.valueOf(balance),getCurrentDateMinusYears(startedYearsAgo));
    }

    private static Date getCurrentDateMinusYears(int years) {
        Calendar now = Calendar.getInstance();
        now.set(Calendar.YEAR, now.get(Calendar.YEAR) - years);
        return now.getTime();
    }
}
