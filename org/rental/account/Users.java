package org.rental.account;

public abstract class Users {
    private String userName;
    private String userPassword;
    public Users(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }
    public Users() {
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
}
