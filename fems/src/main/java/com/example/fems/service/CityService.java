package com.example.fems.service;

import com.example.fems.feign.CityClient;
import com.example.fems.model.City;
import com.example.fems.model.Id;
import com.example.fems.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CityService {

    private CityClient cityClient;

    @Autowired
    public CityService(CityClient cityClient){
        this.cityClient = cityClient;
    }

    public ResultVO<List<City>> getCityByIdPath(Integer id){
        return cityClient.getCityByIdPath(id);
    }

    public ResultVO<List<City>> getCityByIdRequestBody(Id id){
        return cityClient.getCityByIdRequestBody(id);
    }

    public ResultVO<List<City>> getCityByIdRequestParam(Integer id){
        return cityClient.getCityByIdRequestParam(id);
    }

}
