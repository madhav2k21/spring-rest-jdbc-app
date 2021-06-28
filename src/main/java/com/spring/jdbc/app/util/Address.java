package com.spring.jdbc.app.util;

public class Address {

    private String addrsLine1;
    private String addrsLine2;
    private String city;
    private String street;

    public String getAddrsLine1() {
        return addrsLine1;
    }

    public void setAddrsLine1(String addrsLine1) {
        this.addrsLine1 = addrsLine1;
    }

    public String getAddrsLine2() {
        return addrsLine2;
    }

    public void setAddrsLine2(String addrsLine2) {
        this.addrsLine2 = addrsLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addrsLine1='" + addrsLine1 + '\'' +
                ", addrsLine2='" + addrsLine2 + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
