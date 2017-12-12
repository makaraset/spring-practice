package com.mkr.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.mkr.repository")
public class MybaticConfiguration {

}
