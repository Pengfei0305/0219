package com.example.demo.exception;

import com.example.demo.Enum.CityResultEnum;

public class CityException extends RuntimeException{

    private Integer code;

    public CityException(CityResultEnum resultEnum){
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public CityException(CityResultEnum resultEnum,String message){
        super(message);

        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
