package com.example.fems.service;

import com.example.fems.config.ClientConfig;
import com.example.fems.feign.CityClient;
import com.example.fems.model.City;
import com.example.fems.model.Id;
import com.example.fems.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestCityService {

    private CityClient cityClient;


    @Autowired
    private ClientConfig clientConfig;

    @Autowired
    public RestCityService(CityClient cityClient){
        this.cityClient = cityClient;
    }

    public ResultVO<List<City>> getCityByIdPath(Integer id){
        RestTemplate restTemplate = new RestTemplate();
        ResultVO<List<City>> response = restTemplate.getForObject(clientConfig.getRestUrl()+"/getCityByIdPath/"+id,ResultVO.class);
        return response;
    }

    public ResultVO<List<City>> getCityByIdRequestBody(Id id){
        RestTemplate restTemplate = new RestTemplate();
        ResultVO response = restTemplate.postForObject(clientConfig.getRestUrl()+"/getCityByIdRequestBody",id,ResultVO.class);
        return response;
    }

    public ResultVO<List<City>> getCityByIdRequestParam(Integer id){
        RestTemplate restTemplate = new RestTemplate();
        ResultVO<List<City>> response = restTemplate.getForObject(clientConfig.getRestUrl()+"/getCityByIdRequestParam?id="+id,ResultVO.class);
        return response;
    }

}
