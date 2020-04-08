package com.weather.spring.cloud.serviceimpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.spring.cloud.config.WeatherApiConfig;
import com.weather.spring.cloud.service.WeatherService;
import com.weather.spring.cloud.vo.WeatherVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @Author: Ant
 * @Date: 2020/4/8 16:01
 * @Description:
 */
@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public WeatherVo getRealTimeWeatherData() {
        /*请求地址*/
        String url = "https://tianqiapi.com/api?version=v61&appid="+ WeatherApiConfig.APPID +"&appsecret="+ WeatherApiConfig.APPSECRET;
        /*http请求*/
        ResponseEntity<String> respString = restTemplate.getForEntity(url,String.class);
        /*返回数据主体*/
        String strBody = null;
        //返回状态码
        if(respString.getStatusCodeValue() == 200){
            strBody =respString.getBody();
        }else{
            strBody = "数据请求错误";
        }

        /*Json 解析*/
        ObjectMapper mapper = new ObjectMapper();
        WeatherVo wv = new WeatherVo();
        try {
            /*json转对象*/
            wv = mapper.readValue(strBody,WeatherVo.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return wv;
    }
}
