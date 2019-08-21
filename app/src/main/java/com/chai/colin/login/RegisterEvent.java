package com.chai.colin.login;

public class RegisterEvent {
    private String accout;
    private String password;

    public RegisterEvent(String accout, String password) {
        this.accout = accout;
        this.password = password;
    }

    public String getAccout() {
        return accout;
    }

    public String getPassword() {
        return password;
    }
}
