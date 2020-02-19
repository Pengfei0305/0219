package com.example.fems.controller;


import com.example.fems.model.City;
import com.example.fems.model.Id;
import com.example.fems.service.CityService;
import com.example.fems.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import java.util.List;

@RestController
public class FeignController {

    private CityService cityService;

    @Autowired
    FeignController(CityService cityService){
        this.cityService = cityService;
    }

    //feign
    @GetMapping("/feign/getCityByIdPath/{id}")
    public ResultVO<List<City>> getCityByIdPath(@PathVariable("id") Integer id){
        ResultVO<List<City>> response = cityService.getCityByIdPath(id);
        return response;
    }

    @GetMapping("/feign/getCityByIdHeader")
    public ResponseEntity<ResultVO<List<City>>> getCityByIdHeader1(@RequestHeader("id") Integer id) {
        ResultVO<List<City>> response = cityService.getCityByIdPath(id);
        return new ResponseEntity<ResultVO<List<City>>>(response, HttpStatus.OK);
    }


    @PostMapping("/getCityByIdRequestBody")
    public ResultVO<List<City>> getCityByIdRequestBody(@RequestBody Id id){
        ResultVO<List<City>> response = cityService.getCityByIdRequestBody(id);
        return response;
    }

    @GetMapping("/getCityByIdRequestParam")
    public ResultVO<List<City>> getCityByIdRequestParam(@RequestParam("id") Integer id){
        ResultVO<List<City>> response = cityService.getCityByIdRequestParam(id);
        return response;
    }

}
