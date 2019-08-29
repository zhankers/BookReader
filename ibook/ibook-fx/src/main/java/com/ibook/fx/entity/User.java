package com.ibook.fx.entity;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private StringProperty username = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();
 
    public User() {
 
    }
 
    public User(String username, String password) {
        setUsername(username);
        setPassword(password);
    }
 
    public String getUsername() {
        return username.get();
    }
 
    public StringProperty usernameProperty() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username.set(username);
    }
 
    public String getPassword() {
        return password.get();
    }
 
    public StringProperty passwordProperty() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password.set(password);
    }
    
}