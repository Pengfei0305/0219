package com.example.fems.service;

import com.example.fems.model.City;
import com.example.fems.model.Id;
import com.example.fems.util.ResultVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestCityServiceTest {

    @Autowired
    CityService cityService;

    @Test
    void getCityByIdPathNotReturnNull() {
        ResultVO<List<City>> resultVO = cityService.getCityByIdPath(1);
        assertNotNull(resultVO.getData());
    }

    @Test
    void getCityByIdRequestBodyNotReturnNull() {
        Id id = new Id();
        id.setId("1");
        ResultVO<List<City>> resultVO = cityService.getCityByIdRequestBody(id);
        assertNotNull(resultVO.getData());
    }

    @Test
    void getCityByIdRequestParamNotReturnNull() {
        ResultVO<List<City>> resultVO = cityService.getCityByIdRequestParam(1);
        assertNotNull(resultVO.getData());
    }

    @Test
    void getCityByIdPathReturnNull() {
        ResultVO<List<City>> resultVO = cityService.getCityByIdPath(4);
        assertNull(resultVO.getData());
    }

    @Test
    void getCityByIdRequestBodyReturnNull() {
        Id id = new Id();
        id.setId("4");
        ResultVO<List<City>> resultVO = cityService.getCityByIdRequestBody(id);
        assertNull(resultVO.getData());
    }

    @Test
    void getCityByIdRequestParamReturnNull() {
        ResultVO<List<City>> resultVO = cityService.getCityByIdRequestParam(4);
        assertNull(resultVO.getData());
    }
}