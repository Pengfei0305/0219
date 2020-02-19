package com.example.fems.controller;


import com.example.fems.model.City;
import com.example.fems.model.Id;
import com.example.fems.service.CityService;
import com.example.fems.service.RestCityService;
import com.example.fems.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class RestfulController {

    private RestCityService restCityService;

    @Autowired
    RestfulController(RestCityService restCityService){
        this.restCityService = restCityService;
    }

    @GetMapping("/rest/getCityByIdPath/{id}")
    public ResultVO<List<City>> getCityByIdPath(@PathVariable("id") Integer id){
        ResultVO<List<City>> response = restCityService.getCityByIdPath(id);
        return response;
    }

    @GetMapping("/rest/getCityByIdHeader")
    public ResponseEntity<ResultVO<List<City>>> getCityByIdHeader1(@RequestHeader("id") Integer id) {
        System.out.println("getCityByIdHeader"+id);
        ResultVO<List<City>> response = restCityService.getCityByIdPath(id);
        return new ResponseEntity<ResultVO<List<City>>>(response, HttpStatus.OK);
    }


    @PostMapping("/rest/getCityByIdRequestBody")
    public ResultVO<List<City>> getCityByIdRequestBody(@RequestBody Id id){
        ResultVO<List<City>> response = restCityService.getCityByIdRequestBody(id);
        return response;
    }

    @GetMapping("/rest/getCityByIdRequestParam")
    public ResultVO<List<City>> getCityByIdRequestParam(@RequestParam("id") Integer id){
        ResultVO<List<City>> response = restCityService.getCityByIdRequestParam(id);
        return response;
    }

}
