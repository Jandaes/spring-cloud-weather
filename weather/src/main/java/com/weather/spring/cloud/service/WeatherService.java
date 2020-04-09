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
     * @param requestIP 用户ip
     * @return
     */
    WeatherVo getRealTimeWeatherData(String requestIP);

    /**
     * 通过城市编号获取实况天气
     * @param cityId 城市编号
     * @return
     */
    WeatherVo getRealTimeWeatherDataByCityId(String cityId);

    /**
     * 通过城市名称获取实况天气
     * @param cityName 城市名称
     * @return
     */
    WeatherVo getRealTimeWeatherDataByCityName(String cityName);

}
