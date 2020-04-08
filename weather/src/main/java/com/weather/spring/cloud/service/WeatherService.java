package com.weather.spring.cloud.service;

import com.weather.spring.cloud.vo.WeatherVo;

/**
 * 天气获取接口
 * @Author: Ant
 * @Date: 2020/4/8 15:57
 * @Description:
 */
public interface WeatherService {

    /**
     * 获取实况天气
     * @return
     */
    WeatherVo getRealTimeWeatherData();

}
