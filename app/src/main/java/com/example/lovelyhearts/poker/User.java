package com.example.lovelyhearts.poker;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by ryan on 4/20/15.
 */
@ParseClassName("User")
public class User extends ParseObject {
    private Integer id;
    private String login;
    private String password;
    private boolean isAdmin;
    private String name;
    private String email;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public void User(){
        //Default Constructor
    }
    public User(Integer id, String login, String password, boolean isAdmin, String name, String email,
                String address1, String address2, String city, String state, String zip, String phone)
    {
        this.id = id;
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
        this.name = name;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address) {
        this.address1 = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address) {
        this.address2 = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
