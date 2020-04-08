package com.weather.spring.cloud.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 空气质量指数
 *
 * @Author: Ant
 * @Date: 2020/4/8 14:40
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AqiVo implements Serializable {
    /**空气质量*/
    private String air;
    /**空气质量等级*/
    private String air_level;
    /**空气质量提示*/
    private String air_tips;
    /**PM2.5	*/
    private String pm25;
    /**PM2.5等级描述	*/
    private String pm25_desc;
    /**PM10*/
    private String pm10;
    /**PM10等级描述	*/
    private String pm10_desc;
    /**o3	*/
    private String o3;
    /**o3等级描述	*/
    private String o3_desc;
    /**no2*/
    private String no2;
    /**no2等级描述	*/
    private String no2_desc;
    /**so2*/
    private String so2;
    /**so2等级描述	*/
    private String so2_desc;
    /**co*/
    private String co;
    /**co描述*/
    private String co_desc;
    /**是否需要带口罩*/
    private String kouzhao;
    /**外出适宜	*/
    private String waichu;
    /**开窗适宜	*/
    private String kaichuang;
    /**是否需要打开净化器	*/
    private String jinghuaqi;
    /**城市编号*/
    private String cityid;
    /**城市名称*/
    private String city;
    /**城市英文名称*/
    private String cityEn;
    /**国家名称*/
    private String country;
    /**国家英文名称*/
    private String countryEn;
}
