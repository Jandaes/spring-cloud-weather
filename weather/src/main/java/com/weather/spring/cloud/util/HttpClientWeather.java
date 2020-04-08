package com.weather.spring.cloud.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @Author: Ant
 * @Date: 2020/4/8 16:04
 * @Description:
 */
public class HttpClientWeather {

    @Autowired
    private RestTemplate restTemplate;

    public void doGet(String url,String response){}

    public void doPost(String url, Map<String,String> requestParameter){}
}
