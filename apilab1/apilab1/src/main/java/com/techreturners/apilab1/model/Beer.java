package com.techreturners.apilab1.model;

public class Beer {
    private final long id;
    private final String name;
    public Beer(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public long getId() {
        return id;
    }
    public String getname() {
        return name;
    }
}
