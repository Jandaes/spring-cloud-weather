package com.weather.spring.cloud.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 天气信息
 *
 * 含：实况天气
 *
 * @Author: Ant
 * @Date: 2020/4/8 14:34
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherVo implements Serializable {
    /**城市ID*/
    private String cityid;
    /**当前日期*/
    private String date;
    /**当前星期*/
    private String week;
    /**气象台更新时间*/
    private String update_time;
    /**城市名称*/
    private String city;
    /**城市英文名称*/
    private String cityEn;
    /**国家名称*/
    private String country;
    /**国家英文名称*/
    private String countryEn;
    /**天气情况*/
    private String wea;
    /**
     * 天气对应图标:固定9种类型(您也可以根据wea字段自己处理):xue、lei、shachen、wu、bingbao、yun、yu、yin、qing
     * */
    private String wea_img;
    /**实时温度*/
    private String tem;
    /**高温*/
    private String tem1;
    /**低温*/
    private String tem2;
    /**风向*/
    private String win;
    /**风力等级*/
    private String win_speed;
    /**风速*/
    private String win_meter;
    /**湿度*/
    private String humidity;
    /**能见度*/
    private String visibility;
    /**气压hPa*/
    private String pressure;
    /**空气质量*/
    private String air;
    /**pm2.5质量*/
    private String air_pm25;
    /**空气质量描述*/
    private String air_level;
    /**空气质量描述*/
    private String air_tips;

    /**气象预警*/
    private AlarmVo alarm;
    /**空气质量指数*/
    private AqiVo aqi;
}
