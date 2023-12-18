package com.ssafy.hogyu.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ssafy.hogyu.dao")
public class DBConfig {

}