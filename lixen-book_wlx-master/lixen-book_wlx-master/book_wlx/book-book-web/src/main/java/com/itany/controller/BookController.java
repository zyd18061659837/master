package com.itany.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itany.service.BookService;
import com.itany.vo.AjaxResult;
import com.itany.vo.BookVO;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Author:wenlixu
 * Date:2019/4/13 13:41
 * Description:
 * Version:1.0
 */
@Controller
@RequestMapping("/book")
public class BookController {


    @Reference
    private BookService bookService;


    @RequestMapping("/findByKeyword")
    public String findByKeyword(@RequestParam("keyword") String keyword,@RequestParam("page")Integer page, Model model) throws IOException, SolrServerException, ParseException {

        BookVO bookVO = bookService.findDoc(keyword, page, 2);
        model.addAttribute("bookList",bookVO);
        model.addAttribute("keyword",keyword);
        return "forward:/showBookList";

    }

    @ResponseBody
    @RequestMapping("/init")
    public String initSolr() throws IOException, SolrServerException {
        bookService.addDoc();
        return "success";
    }

}
