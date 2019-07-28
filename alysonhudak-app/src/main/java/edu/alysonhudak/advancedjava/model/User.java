package edu.alysonhudak.advancedjava.model;

/**
 * A user for the stock ticker system.
 *
 * @author Alyson Hudak
 */
public class User {

    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}