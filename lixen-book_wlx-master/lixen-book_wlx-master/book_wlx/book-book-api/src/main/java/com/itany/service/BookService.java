package com.itany.service;

import com.itany.pojo.BookType;
import com.itany.vo.BookVO;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Author:wenlixu
 * Date:2019/4/13 13:37
 * Description:
 * Version:1.0
 */
public interface BookService {

    /**
     * 初始化solr服务器，将结构保存在solr中
     *
     */
    void addDoc() throws IOException, SolrServerException;

    BookVO findDoc(String keyword,Integer page,Integer rows) throws IOException, SolrServerException, ParseException;


}