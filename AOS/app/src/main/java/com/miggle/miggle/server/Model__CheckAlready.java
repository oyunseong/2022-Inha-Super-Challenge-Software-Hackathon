package com.miggle.miggle.server;

public class Model__CheckAlready {
    private boolean isRight = false;
    private String id;
    private String password;

    public Model__CheckAlready(String phone) {
        this.id = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    @Override
    public String toString() {
        return "RepoCheckAlready{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}