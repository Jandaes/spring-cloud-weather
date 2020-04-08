package com.weather.spring.cloud.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 响应封装类
 *
 * @Author: Ant
 * @Date: 2020/4/8 15:07
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponse {
    /**状态：success、error*/
    private String status;
    /**描述：失败原因*/
    private String desc;
    /**具体数据*/
    private Object data;


    /**
     * 成功
     * @param obj 数据
     * @return
     */
    public static WeatherResponse success(Object obj){
        WeatherResponse wr = WeatherResponse.builder().data(obj).desc("ok").status("success").build();
        return wr;
    }

    /**
     * 错误
     * @param desc 错误描述
     * @return
     */
    public static WeatherResponse error(String desc){
        WeatherResponse wr = WeatherResponse.builder().data("").desc(desc).status("error").build();
        return wr;
    }
}
