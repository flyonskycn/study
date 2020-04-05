package com.flyonsky.mapper;

import com.flyonsky.model.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author luowengang
 * @date 2020/4/5 23:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CityMapperTest {

    @Autowired
    private CityMapper mapper;

    @Test
    public void testSave(){
        City city = new City();
        city.setName("深圳");
        city.setState("中国");
        city.setCountry("广东");

        mapper.save(city);
    }

    @Test
    public void testQueryAll(){
        List<City> cityList = mapper.queryAll();

        System.out.println(cityList.size());
    }
}
