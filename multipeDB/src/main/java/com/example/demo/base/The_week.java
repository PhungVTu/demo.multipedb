package com.example.demo.base;

public enum The_week {

    MONDAY("Thu hai"),
    TUESDAY("Thu ba"),
    WEDNESDAY("Thu tư"),
    THURSDAY("Thu nam"),
    FRIDAY("Thu sau"),
    SATURDAY("Thu bay"),
    SUNDAY("Chu nhat");
    The_week(String name){
        this.name = name;
    }
    private String name;
    public String getName(){
        return this.name;
    }
}
