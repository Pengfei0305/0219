package com.example.demo.controller;


import com.example.demo.Enum.CityResultEnum;
import com.example.demo.exception.CityException;
import com.example.demo.model.City;
import com.example.demo.model.Id;
import com.example.demo.repository.CityRepository;
import com.example.demo.util.ResultVO;
import com.example.demo.util.ResultVOUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {


    @GetMapping("/getCityByIdPath/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultVO<List<City>> getCityById(@PathVariable("id") Integer id){
        List<City> city;
        try {
            city = CityRepository.map.get(id);
            if(city == null){
                //return ResultVOUtil.error(CityResultEnum.CITY_NOT_EXIST.getCode(),CityResultEnum.CITY_NOT_EXIST.getMessage());
                throw new CityException(CityResultEnum.CITY_NOT_EXIST);
            }
        }catch(Exception e){
            throw new CityException(CityResultEnum.CITY_NOT_EXIST);
        }
        return ResultVOUtil.success(city);
    }

    @PostMapping("/getCityByIdRequestBody")
    @ResponseStatus(HttpStatus.OK)
    public ResultVO<List<City>> getCityByIdRequestBody(@RequestBody Id id){
        List<City> city;
        try {
            city = CityRepository.map.get(Integer.parseInt(id.getId()));
            if (city == null) {
                //            return ResultVOUtil.error(CityResultEnum.CITY_NOT_EXIST.getCode(),CityResultEnum.CITY_NOT_EXIST.getMessage());
                throw new CityException(CityResultEnum.CITY_NOT_EXIST);
            }
        }catch(Exception e){
            throw new CityException(CityResultEnum.CITY_NOT_EXIST);
        }
        return ResultVOUtil.success(city);
    }

    @GetMapping("/getCityByIdRequestParam")
    @ResponseStatus(HttpStatus.OK)
    public ResultVO<City> getCityByIdRequestParam(@RequestParam("id") Integer id){
        System.out.println(id);
        List<City> city;
        try {
            city = CityRepository.map.get(id);
            if(city == null){
                //return ResultVOUtil.error(CityResultEnum.CITY_NOT_EXIST.getCode(),CityResultEnum.CITY_NOT_EXIST.getMessage());
                throw new CityException(CityResultEnum.CITY_NOT_EXIST);
            }
        }catch(Exception e){
            throw new CityException(CityResultEnum.CITY_NOT_EXIST);
        }
        return ResultVOUtil.success(city);
    }

}
