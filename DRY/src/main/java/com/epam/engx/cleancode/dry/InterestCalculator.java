package com.epam.engx.cleancode.dry;

import com.epam.engx.cleancode.dry.thirdpartyjar.Profitable;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class InterestCalculator implements Profitable {

    private static final int AGE = 60;
    private static final double INTEREST_PERCENT = 4.5d;
    private static final double SENIOR_PERCENT = 5.5d;
    private static final int BONUS_AGE = 13;
    private static final int LEAP_YEAR_SHIFT = 1;

    public BigDecimal calculateInterest(AccountDetails accountDetails) {
        if (isAccountStartedAfterBonusAge(accountDetails)) {
            return getInterest(accountDetails);
        } else {
            return BigDecimal.ZERO;
        }
    }

    private boolean isAccountStartedAfterBonusAge(AccountDetails accountDetails) {
        return getDifferenceInYears(accountDetails.getBirth(),accountDetails.getStartDate()) > BONUS_AGE;
    }

    private int getDifferenceInYears(Date startDate, Date endDate) {
        Calendar startCalendar = getCalendar(startDate);
        Calendar endCalendar = getCalendar(endDate);

        return calculateDiffYears(startCalendar, endCalendar);
    }

    private int calculateDiffYears(Calendar startCalendar, Calendar endCalendar) {
        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);

        int startDate = startCalendar.get(Calendar.DAY_OF_YEAR);
        int endDate = endCalendar.get(Calendar.DAY_OF_YEAR) + LEAP_YEAR_SHIFT;

        return endDate < startDate ? diffYear - 1 : diffYear;
    }

    private BigDecimal getInterest(AccountDetails accountDetails) {
        BigDecimal interest = BigDecimal.ZERO;

        if (isAccountStartedAfterBonusAge(accountDetails)) {
            if (AGE <= accountDetails.getAge()) {
                interest = getInterestBasedOnAge(accountDetails, SENIOR_PERCENT);
            } else {
                interest = getInterestBasedOnAge(accountDetails, INTEREST_PERCENT);
            }
        }
        return interest;
    }

    private BigDecimal getInterestBasedOnAge(AccountDetails accountDetails, double interestPercent) {
        return BigDecimal.valueOf(accountDetails.getBalance().doubleValue()
                * getDifferenceInYears(accountDetails.getStartDate(), new Date())
                * interestPercent / 100);
    }

    private Calendar getCalendar(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar;
    }
}
