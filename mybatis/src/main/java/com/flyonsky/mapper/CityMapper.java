package com.flyonsky.mapper;

import com.flyonsky.model.City;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author luowengang
 * @date 2020/4/5 22:55
 */
@Mapper
public interface CityMapper {

    int save(City city);

    List<City> queryAll();
}
