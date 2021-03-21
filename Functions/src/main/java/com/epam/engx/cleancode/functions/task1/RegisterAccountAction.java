package com.epam.engx.cleancode.functions.task1;

import com.epam.engx.cleancode.functions.task1.thirdpartyjar.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.epam.engx.cleancode.functions.task1.thirdpartyjar.CheckStatus.OK;

public class RegisterAccountAction {
    private static final int MIN_LENGTH_ACCOUNT_NAME = 5;
    private static final int MIN_LENGTH_ACCOUNT_PASSWORD = 8;

    private PasswordChecker passwordChecker;
    private AccountManager accountManager;

    public void register(Account account) {
        accountValidation(account);
        accountBuilder(account);
    }

    private void accountValidation(Account account) {
        if (account.getName().length() <= MIN_LENGTH_ACCOUNT_NAME) {
            throw new WrongAccountNameException();
        }
        String password = account.getPassword();
        if (password.length() <= MIN_LENGTH_ACCOUNT_PASSWORD) {
            throw new TooShortPasswordException();
        }
        if (passwordChecker.validate(password) != OK) {
            throw new WrongPasswordException();
        }
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
