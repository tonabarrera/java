package com.tona.backendninja.model;

/**
 * @author tona created on 14/03/2018 for backendninja.
 */
public class UserCredential {
    private String username;
    private String password;

    public UserCredential(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserCredential() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserCredential{" + "username='" + username + '\'' + ", password='" + password +
                '\'' + '}';
    }
}
