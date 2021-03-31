package com.epam.engx.cleancode.functions.task1;

import com.epam.engx.cleancode.functions.task1.thirdpartyjar.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.epam.engx.cleancode.functions.task1.thirdpartyjar.CheckStatus.OK;

public class RegisterAccountAction {
    private static final int NAME_MIN_LENGTH = 5;
    private static final int MIN_LENGTH_PASSWORD = 8;

    private PasswordChecker passwordChecker;
    private AccountManager accountManager;

    public void register(Account account) {
        validateAccount(account);
        accountBuilder(account);
    }

    private void validateAccount(Account account) {
        checkLoginAccount(account);
        checkAccountPassword(checkLengthPassword(account));
    }

    private void checkLoginAccount(Account account) {
        if (account.getName().length() <= NAME_MIN_LENGTH) {
            throw new WrongAccountNameException();
        }
    }

    private void checkAccountPassword(String password) {
        if (passwordChecker.validate(password) != OK) {
            throw new WrongPasswordException();
        }
    }

    private String checkLengthPassword(Account account) {
        if (account.getPassword().length() <= MIN_LENGTH_PASSWORD) {
            throw new TooShortPasswordException();
        }
        return account.getPassword();
    }

    private void accountBuilder(Account account) {
        account.setCreatedDate(new Date());
        List<Address> addresses = new ArrayList<>();
        addresses.add(account.getHomeAddress());
        addresses.add(account.getWorkAddress());
        addresses.add(account.getAdditionalAddress());
        account.setAddresses(addresses);
        accountManager.createNewAccount(account);
    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public void setPasswordChecker(PasswordChecker passwordChecker) {
        this.passwordChecker = passwordChecker;
    }
}
