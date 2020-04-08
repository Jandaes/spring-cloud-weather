package com.weather.spring.cloud.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 	气象预警
 *
 * @Author: Ant
 * @Date: 2020/4/8 14:38
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlarmVo implements Serializable {
    /**预警类型*/
    private String alarm_type;
    /**预警级别*/
    private String alarm_level;
    /**预警详细信息*/
    private String alarm_content;
}
