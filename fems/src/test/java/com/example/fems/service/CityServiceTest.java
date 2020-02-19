package com.example.fems.service;

import com.example.fems.feign.CityClient;
import com.example.fems.model.City;
import com.example.fems.model.Id;
import com.example.fems.util.ResultVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CityServiceTest {

    CityService cityService;

    @Mock
    CityClient cityClient;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        this.cityService = new CityService(cityClient);
    }


    @Test
    void getCityByIdPath() {
        when(cityClient.getCityByIdPath(1)).thenReturn(new ResultVO<>());
        assertNotNull(cityService.getCityByIdPath(1));
    }

    @Test
    void getCityByIdRequestBody() {
        Id id = new Id();
        id.setId("1");
        when(cityClient.getCityByIdRequestBody(id)).thenReturn(new ResultVO<>());
        assertNotNull(cityService.getCityByIdRequestBody(id));
    }

    @Test
    void getCityByIdRequestParam() {
        when(cityClient.getCityByIdRequestParam(1)).thenReturn(new ResultVO<>());
        assertNotNull(cityService.getCityByIdRequestParam(1));
    }
}