package com.example.lovelyhearts.poker;

import com.parse.ParseObject;
import com.parse.ParseClassName;

/**
 * Created by ryan on 4/20/15.
 */
@ParseClassName("Location")
public class Location extends ParseObject{

    private Integer id;
    private String name;
    private String email;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String url;

    public void Location()
    {
        this.id = 0;
        this.name = "";
        this.email = "";
        this.address1 = "";
        this.address2 = "";
        this.city = "";
        this.state = "";
        this.zip = "";
        this.phone = "";
        this.url = "";
    }
/*
    public Location(Integer id, String name, String email, String address1, String address2,
                    String city, String state, String zip, String phone, String url)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.url = url;
    }
*/
    void SetId(Integer id) {
        this.id = id;
    }
    void SetName(String name) {
        this.name = name;
    }
    void SetEmail(String email) {
        this.email = email;
    }
    void SetAddress1(String address1) {
        this.address1 = address1;
    }
    void SetAddress2(String address2) {
        this.address2 = address2;
    }
    void SetCity(String city) {
        this.city = city;
    }
    void SetState(String state) {
        this.state = state;
    }
    void SetZip(String zip) {
        this.zip = zip;
    }
    void SetPhone(String phone) {
        this.phone = phone;
    }
    void SetUrl(String url) {
        this.url = url;
    }

    Integer SetId() {
        return this.id;
    }
    String SetName() {
        return this.name;
    }
    String SetEmail() {
        return this.email;
    }
    String SetAddress1() {
        return this.address1;
    }
    String SetAddress2() {
        return this.address2;
    }
    String SetCity() {
        return this.city;
    }
    String SetState() {
        return this.state;
    }
    String SetZip() {
        return this.zip;
    }
    String SetPhone() {
        return this.phone;
    }
    String GetUrl() {
        return this.url;
    }

}
