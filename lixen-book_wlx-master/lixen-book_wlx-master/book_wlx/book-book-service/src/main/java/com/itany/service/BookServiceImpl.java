package com.itany.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.itany.mapper.BookMapper;
import com.itany.pojo.Book;
import com.itany.pojo.BookType;
import com.itany.pojo.Press;
import com.itany.vo.BookVO;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Author:wenlixu
 * Date:2019/4/13 13:42
 * Description:
 * Version:1.0
 */
@Component
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Throwable.class)
public class BookServiceImpl implements BookService {

    @Autowired
    private HttpSolrClient solrClient;

    @Resource
    private BookMapper bookMapper;

    @Override
    public void addDoc() throws IOException, SolrServerException {

        List<Book> bookList =  bookMapper.selectAll();

            for(Book book:bookList){
                SolrInputDocument doc = new SolrInputDocument();
                doc.addField("id",book.getId());
                doc.addField("bookname",book.getBookName());
                doc.addField("name",book.getPress().getName());
                doc.addField("bookintroduce",book.getBookIntroduce());
                doc.addField("author",book.getAuthor());
                doc.addField("publishdate",new SimpleDateFormat("yyyy-MM-dd")
                        .format(book.getPublishDate()));
                doc.addField("imgurl",book.getImgUrl());
                doc.addField("price",book.getPrice());
                solrClient.add(doc);
                solrClient.commit();
            }

    }

    @Override
    public BookVO findDoc(String keyword, Integer page, Integer rows) throws IOException, SolrServerException, ParseException {

        BookVO bookVO = new BookVO();
        Set<Map<String,String>> list = new HashSet<>();

        List<String> columns = Arrays.asList("bookname","name","bookintroduce","author");
            String queryStr = "bookname:"+keyword+" OR name:"+keyword+" OR author:"+keyword+" OR bookintroduce:"+keyword;


            SolrQuery solrQuery = new SolrQuery();
            solrQuery.setQuery(queryStr);
            solrQuery.setHighlight(true);

            //设置分页
            solrQuery.setStart((page-1)*rows);
            solrQuery.setRows(rows);

            solrQuery.setHighlightSimplePre("<font color='red'>");
            solrQuery.setHighlightSimplePost("</font>");
            solrQuery.setParam("hl.fl","*");

            QueryResponse response = solrClient.query(solrQuery);
            SolrDocumentList results = response.getResults();

            //查询结果总条数
            int count = (int) results.getNumFound();
            System.out.println("count"+count);
            if(count <= rows){
                bookVO.setTotal(1);
            }else{
                bookVO.setTotal(count%rows == 0 ? count%rows : count%rows+1);
            }


            List<String> idContainer = new ArrayList<>();

            for(int i = 0;i<results.size();i++){
                SolrDocument document = results.get(i);
                String id = (String) document.get("id");
                Map<String,List<String>> highLightMap = response.getHighlighting().get(id);

                for(String temp:columns){

                    List<String> tempList = highLightMap.get(temp);

                    if(null != tempList ){

                        //如果容器中 有该id，则不进行下列操作
                        if(null != idContainer && idContainer.contains(document.get("id"))){
                            continue;
                        }
                        idContainer.add((String) document.get("id"));

                        Map<String,String> map = new HashMap<>();
                        map.put("id", (String) document.get("id"));
                        map.put("bookname", (String) document.get("bookname"));
                        map.put("author", (String) document.get("author"));
                        map.put("bookintroduce", (String) document.get("bookintroduce"));
                        map.put("imgurl", (String) document.get("imgurl"));
                        map.put("publishdate", (String) document.get("publishdate"));
                        map.put("price", document.get("price").toString());
                        map.put("name", (String) document.get("name"));
                        map.put(temp,tempList.get(0));
                        list.add(map);
                    }
//                    else {
//                        map.put(temp, (String) document.get(temp));
//                    }
                }
            }

        bookVO.setBookList(list);
        return bookVO;
    }


}
