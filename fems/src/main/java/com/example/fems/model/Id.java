package com.example.fems.model;

import com.example.fems.util.ResultVO;

public class Id {

    private String id;

    private String response;

    @Override
    public String toString() {
        return "Id{" +
                "id='" + id + '\'' +
                ", response=" + response +
                '}';
    }

    public Id(String id, String response) {
        this.id = id;
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
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
