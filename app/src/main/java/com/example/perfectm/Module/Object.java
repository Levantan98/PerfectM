package com.example.perfectm.Module;

public class Object {
    private int imgAvt;
    private String name;
    private int age;
    private String city;
    private boolean isOnline;


    public Object(int imgAvt, String name, int age, String city, boolean isOnline) {
        this.imgAvt = imgAvt;
        this.name = name;
        this.age = age;
        this.city = city;
        this.isOnline = isOnline;
    }

    public int getImgAvt() {
        return imgAvt;
    }

    public void setImgAvt(int imgAvt) {
        this.imgAvt = imgAvt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }
}

