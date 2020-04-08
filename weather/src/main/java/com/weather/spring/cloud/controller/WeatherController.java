package com.weather.spring.cloud.controller;

import com.weather.spring.cloud.service.WeatherService;
import com.weather.spring.cloud.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Janda
 * @Date: 2020/4/8 14:06
 * @Description:
 */
@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;


    /**
     * 获取实况天气
     * @return
     */
    @GetMapping("/index")
    public WeatherResponse getRealTimeWeatherData(){
        return WeatherResponse.success(weatherService.getRealTimeWeatherData());
    }

}