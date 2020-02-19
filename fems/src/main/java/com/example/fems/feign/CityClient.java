package com.example.fems.feign;

import com.example.fems.model.City;
import com.example.fems.model.Id;
import com.example.fems.util.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//FOR LOCAL DEV
@FeignClient(value = "city-crud", url="${client.feignUrl}")

//@FeignClient(name = "${clients.authors.name}")
public interface CityClient {

    @GetMapping("/getCityByIdPath/{id}")
    ResultVO<List<City>> getCityByIdPath(@PathVariable("id") Integer id);

    @PostMapping("/getCityByIdRequestBody")
    ResultVO<List<City>> getCityByIdRequestBody(@RequestBody Id id);

    @GetMapping("/getCityByIdRequestParam")
    ResultVO<List<City>> getCityByIdRequestParam(@RequestParam("id") Integer id);

}
