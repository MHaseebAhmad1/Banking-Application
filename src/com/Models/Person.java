package com.Models;

public class Person {
    private final String name;
    private final String idNum;

    public Person(String name, String idNum) {
        this.name = name;
        this.idNum = idNum;
    }

    public String getName() {
        return name;
    }

    public String getIdNum() {
        return idNum;
    }
}
