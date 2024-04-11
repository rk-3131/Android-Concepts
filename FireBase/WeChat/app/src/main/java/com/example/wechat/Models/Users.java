package com.example.wechat.Models;

public class Users {
    String name;
    String profilePicture;
    String email;
    String userId;
    String lastMessage;
    String password;

    public Users(String name, String profilePicture, String email, String userId, String lastMessage, String password) {
        this.name = name;
        this.profilePicture = profilePicture;
        this.email = email;
        this.userId = userId;
        this.lastMessage = lastMessage;
        this.password = password;
    }

    public Users() {
    }

    public Users(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
