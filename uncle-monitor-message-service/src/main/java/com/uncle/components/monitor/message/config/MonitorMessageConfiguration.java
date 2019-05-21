package com.uncle.components.monitor.message.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 杨戬
 * @email yangbo@email.com
 */
@Configuration
@ComponentScan(basePackages = {
        "com.chaos.components.monitor.message"
})
@MapperScan(basePackages = {
        "com.chaos.components.monitor.message.dao"
})
public class MonitorMessageConfiguration {

}
