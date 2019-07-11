package com.itany.conf;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author:wenlixu
 * Date:2019/4/13 13:47
 * Description:
 * Version:1.0
 */
@Configuration
public class SolrConfig {

    @Bean(name = "solrClient")
    public HttpSolrClient solrClient(){

        return new HttpSolrClient.Builder("Http://localHost:8080/solr/t_book")
                .withConnectionTimeout(10000)
                .withSocketTimeout(6000)
                .build();
    }
}
