package com.example.demo.Enum;

/**
 * @author Pengfei
 * @date 2020-2-18 10:46
 */

public enum CityResultEnum {
    CITY_NOT_EXIST(1,"Can not find city by this id"),

    ;

    private Integer code;

    private String message;

    CityResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
