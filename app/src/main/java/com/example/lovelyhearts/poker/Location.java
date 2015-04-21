package com.example.lovelyhearts.poker;

/**
 * Created by ryan on 4/20/15.
 */
public class Location {
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
}
