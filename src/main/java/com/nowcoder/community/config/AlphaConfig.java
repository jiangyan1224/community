package com.nowcoder.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

@Configuration
public class AlphaConfig {

    @Bean
    public SimpleDateFormat getSimpleDateFormat(){
        //SimpleDateFormat本身就是单例模式
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    @Bean
    public String[] getString(){
        return new String[1];
    }
}
