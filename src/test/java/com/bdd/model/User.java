package com.bdd.model;



public class User {
    private String name;
    private String code;

    public User(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
