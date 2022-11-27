package com.flyonsky.controller;

import com.flyonsky.model.City;
import com.flyonsky.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author luowengang
 * @date 2022/11/26 11:49
 */
@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    @ResponseBody
    @RequestMapping(value = "/city/all",method = RequestMethod.GET)
    public List<City> queryAll(){
        return this.getCityService().queryAll();
    }

    public CityService getCityService() {
        return cityService;
    }
}
