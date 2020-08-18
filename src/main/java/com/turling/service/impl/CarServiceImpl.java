package com.turling.service.impl;

import com.turling.entity.Car;
import com.turling.mapper.CarMapper;
import com.turling.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 汽车业务逻辑实现类
 */
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarMapper carMapper;
    @Override
    public int addCar(Car car) {
        return carMapper.insertSelective(car);
    }
}
