package com.weather.spring.cloud.serviceimpl;

import ch.qos.logback.core.util.TimeUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.spring.cloud.config.WeatherApiConfig;
import com.weather.spring.cloud.service.WeatherService;
import com.weather.spring.cloud.vo.WeatherVo;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

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

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 获取实况天气：
     * 1、缓存查询
     * 2、不存在就调用接口
     * @return
     */
    @Override
    public WeatherVo getRealTimeWeatherData() {
        /*Redis*/
        String key = "v61";
        /*返回数据主体*/
        String strBody = null;


        /**
         * 先查缓存、在调接口
         * */
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
        /*判断是否有该缓存*/
        if(stringRedisTemplate.hasKey(key)){
            strBody = ops.get(key);
        }else {
            /*请求地址*/
            String url = "https://tianqiapi.com/api?version=v61&appid="+ WeatherApiConfig.APPID +"&appsecret="+ WeatherApiConfig.APPSECRET;
            /*http请求*/
            ResponseEntity<String> respString = restTemplate.getForEntity(url,String.class);

            //返回状态码
            if(respString.getStatusCodeValue() == 200){
                strBody =respString.getBody();
            }else{
                strBody = "数据请求错误";
            }

            /*写入数据至缓存、25分钟过期*/
            ops.set(key,strBody,25, TimeUnit.SECONDS);
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
