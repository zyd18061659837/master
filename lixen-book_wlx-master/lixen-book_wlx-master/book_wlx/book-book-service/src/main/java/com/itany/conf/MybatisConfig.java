package com.itany.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Author:wenlixu
 * Date:2019/4/10 13:12
 * Description:
 * Version:1.0
 */
@Configuration
@MapperScan("com.itany.mapper")
public class MybatisConfig {

    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return new DruidDataSource();
    }
}
