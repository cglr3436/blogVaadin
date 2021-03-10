package com.uniyaz.domain;

public class Katagori {
private int id;
private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Katagori(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
