package com.example.demo.repository;

import com.example.demo.model.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityRepository {



    public static List<City> cityList1 = new ArrayList<City>(){
        {
            add(new City(1L,"Naperville1",60563L));
            add(new City(2L,"Naperville2",60563L));
            add(new City(3L,"Naperville3",60563L));
            add(new City(4L,"Naperville4",60563L));
        }
    };

    public static List<City> cityList2 = new ArrayList<City>(){
        {
            add(new City(5L,"Chicago5",60563L));
            add(new City(6L,"Chicago6",60563L));
            add(new City(7L,"Chicago7",60563L));
            add(new City(8L,"Chicago8",60563L));
        }
    };

    public static Map<Integer, List<City>> map = new HashMap<Integer, List<City>>() {
        {
        put(1,  cityList1);
        put(2,  cityList2);
    }};

}
