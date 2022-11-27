package com.flyonsky.service;

import com.flyonsky.mapper.CityMapper;
import com.flyonsky.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luowengang
 * @date 2022/11/26 11:47
 */
@Service
public class CityService {
    @Autowired
    private CityMapper cityMapper;

    public List<City> queryAll(){
        return getCityMapper().queryAll();
    }

    protected CityMapper getCityMapper() {
        return cityMapper;
    }
}
