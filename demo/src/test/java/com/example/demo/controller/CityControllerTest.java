package com.example.demo.controller;

import com.example.demo.config.LocalDateTimeSerializer;
import com.example.demo.exception.CityException;
import com.example.demo.model.Id;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CityController.class)
@ExtendWith(SpringExtension.class)
class CityControllerTest {

    private MockMvc mockMvc;

    @SpyBean
    private CityController controller;

    private Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class,
                    new LocalDateTimeSerializer()).create();

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    void getCityById_Returns200() throws Exception {
        mockMvc.perform(get("/getCityByIdPath/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getCityById_ReturnsException() throws Exception {

        Assertions.assertThrows(NestedServletException.class, () -> {
            mockMvc.perform(get("/getCityByIdPath/{id}", 100))
                    .andDo(print())
                    .andExpect(status().isOk());
        });

    }

    @Test
    void getCityByIdRequestBody_Returns200() throws Exception {
        Id id = new Id();
        id.setId("1");
        String inputJson = gson.toJson(id);
        mockMvc.perform(post("/getCityByIdRequestBody")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getCityByIdRequestBody_ReturnsException() throws Exception {
        Id id = new Id();
        id.setId("3");
        String inputJson = gson.toJson(id);
        Assertions.assertThrows(NestedServletException.class, () -> {
            mockMvc.perform(post("/getCityByIdRequestBody")
                    .content(inputJson)
                    .contentType(MediaType.APPLICATION_JSON)
                    .characterEncoding("utf-8"))
                    .andDo(print());
        });

    }

    @Test
    void getCityByIdRequestParam_Returns200() throws Exception {
        mockMvc.perform(get("/getCityByIdRequestParam").queryParam("id","1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getCityByIdRequestParam_ReturnsException() throws Exception {
        Assertions.assertThrows(NestedServletException.class, () -> {
            mockMvc.perform(get("/getCityByIdRequestParam").queryParam("id","100"))
                    .andDo(print())
                    .andExpect(content().string("{\"code\":1,\"msg\":\"Can not find city by this id\",\"data\":null}"))
                    .andReturn();
        });

    }
}