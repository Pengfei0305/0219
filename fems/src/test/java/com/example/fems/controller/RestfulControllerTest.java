package com.example.fems.controller;

import com.example.fems.model.Id;
import com.example.fems.service.CityService;
import com.example.fems.service.RestCityService;
import com.example.fems.util.ResultVO;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class RestfulControllerTest {
    @Autowired
    FeignController feignController;

    @Mock
    RestCityService restCityService;

    @Test
    void getCityByIdPath() {

        when(restCityService.getCityByIdPath(1)).thenReturn(new ResultVO<>());
        assertNotNull(feignController.getCityByIdPath(1));

    }

    @Test
    void getCityByIdHeader1() {
        when(restCityService.getCityByIdPath(2)).thenReturn(new ResultVO<>());
        assertNotNull(feignController.getCityByIdPath(2));
    }

    @Test
    void getCityByIdRequestBody() {
        Id id = new Id();
        id.setId("1");
        when(restCityService.getCityByIdRequestBody(id)).thenReturn(new ResultVO<>());
        assertNotNull(feignController.getCityByIdRequestBody(id));
    }

    @Test
    void getCityByIdRequestParam() {
        when(restCityService.getCityByIdRequestParam(1)).thenReturn(new ResultVO<>());
        assertNotNull(feignController.getCityByIdRequestParam(1));
    }
}