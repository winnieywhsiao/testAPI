package com.example.testapi;

public class fields {
    private String password;
    private String email;
    private String phone;
    private String name;

    //欄位
    public fields(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public fields(String password, String email, String phone, String name) {
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }
}
