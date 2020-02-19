package com.example.demo.model;

public class Id {

    private String id;

    @Override
    public String toString() {
        return "Id{" +
                "id='" + id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Id() {
    }
}
