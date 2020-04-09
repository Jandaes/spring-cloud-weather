package com.weather.spring.cloud.serviceimpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.spring.cloud.config.WeatherApiConfig;
import com.weather.spring.cloud.service.WeatherService;
import com.weather.spring.cloud.vo.WeatherVo;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final static Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);

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
    public WeatherVo getRealTimeWeatherData(String requestIP) {
        /*Redis*/
        String key = "v61-"+requestIP;
        /*返回数据主体*/
        String strBody = null;


        /**
         * 先查缓存、在调接口
         * */
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
        /*判断是否有该缓存*/
        if(stringRedisTemplate.hasKey(key)){
            logger.info("Redis has Data");
            strBody = ops.get(key);
        }else {
            logger.info("Redis don`t has Data");
            /*请求地址*/
            String url = "https://tianqiapi.com/api?version=v61&appid="+ WeatherApiConfig.APPID +"&appsecret="+ WeatherApiConfig.APPSECRET+"&ip="+requestIP;
            /*http请求*/
            ResponseEntity<String> respString = restTemplate.getForEntity(url,String.class);
            //返回状态码
            if(respString.getStatusCodeValue() == HttpStatus.SC_OK){
                strBody =respString.getBody();
            }else{
                strBody = "数据请求错误";
            }
            /*写入数据至缓存、25分钟过期*/
            ops.set(key,strBody,25, TimeUnit.MINUTES);
        }
        /*Json 解析*/
        ObjectMapper mapper = new ObjectMapper();
        WeatherVo wv = new WeatherVo();
        try {
            /*json转对象*/
            wv = mapper.readValue(strBody,WeatherVo.class);
        } catch (JsonProcessingException e) {
            logger.error("Error ",e);
        }
        return wv;
    }
}
