package com.example.fems.controller;

import com.example.fems.model.City;
import com.example.fems.model.Id;
import com.example.fems.service.CityService;
import com.example.fems.util.ResultVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class FeignControllerTest {

    @Mock
    CityService cityService;

    FeignController feignController;

    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        feignController = new FeignController(cityService);
    }


    @Test
    void getCityByIdPathNotReturnNull() {

        when(cityService.getCityByIdPath(1)).thenReturn(new ResultVO<>());
        assertNotNull(feignController.getCityByIdPath(1));
    }

    @Test
    void getCityByIdPath() {
        when(cityService.getCityByIdPath(1)).thenReturn(new ResultVO<>());
        assertNotNull(feignController.getCityByIdPath(1));
    }

    @Test
    void getCityByIdHeader1() {
        when(cityService.getCityByIdPath(1)).thenReturn(new ResultVO<>());
        assertNotNull(feignController.getCityByIdPath(1));
    }

    @Test
    void getCityByIdRequestBody() {
        Id id = new Id();
        id.setId("1");
        when(cityService.getCityByIdRequestBody(id)).thenReturn(new ResultVO<>());
        assertNotNull(feignController.getCityByIdRequestBody(id));
    }

    @Test
    void getCityByIdRequestParam() {
        when(cityService.getCityByIdRequestParam(1)).thenReturn(new ResultVO<>());
        assertNotNull(feignController.getCityByIdRequestParam(1));
    }
}