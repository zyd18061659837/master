package com.itany.conf;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

import java.nio.charset.Charset;

/**
 * Author:wenlixu
 * Date:2019/4/10 13:49
 * Description:
 * Version:1.0
 */
@Configuration
public class OtherConfig {

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters(){
        FastJsonHttpMessageConverter fastConverter  = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastJsonConfig.setCharset(Charset.forName("UTF8"));
        fastConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter converter = fastConverter;
        return new HttpMessageConverters(converter);
    }
}
