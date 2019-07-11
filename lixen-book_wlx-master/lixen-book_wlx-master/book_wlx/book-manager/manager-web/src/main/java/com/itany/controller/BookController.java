package com.itany.controller;

import com.github.pagehelper.PageInfo;
import com.itany.pojo.Book;
import com.itany.service.BookService;
import com.itany.vo.AjaxResult;
import com.itany.vo.BookAndSupplierVO;
import com.itany.vo.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:wenlixu
 * Date:2019/3/27 18:20
 * Description:
 * Version:1.0
 */
@RequestMapping("/book")
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @ResponseBody
    @RequestMapping("/sendToCheck")
    public AjaxResult sendToCheck(BookAndSupplierVO bookAndSupplierVO, MultipartFile file) throws IOException {
        AjaxResult result = new AjaxResult();
        bookService.addToCheck(bookAndSupplierVO,file);
        result.setSuccess(true);
        return result;
    }

    @ResponseBody
    @RequestMapping("/findById/{id}")
    public AjaxResult findById(@PathVariable("id") Integer id){
        AjaxResult result = new AjaxResult();
        Book book = bookService.findById(id);
        result.setData(book);
        result.setSuccess(true);
        return result;
    }

    @ResponseBody
    @RequestMapping("/findByConditions")
    public Map<String,Object> findByConditions(BookVO bookVO){

        Map<String,Object> map = new HashMap<>();
        PageInfo<Book> books = bookService.findByConditions(bookVO);

        map.put("rows",books.getList());
        map.put("total",books.getTotal());

        return map;
    }

    @ResponseBody
    @RequestMapping("/enableBook/{id}")
    public AjaxResult enableBook(@PathVariable("id") Integer id){
        AjaxResult result = new AjaxResult();
        bookService.enableBook(id);
        result.setSuccess(true);
        return result;
    }

    @ResponseBody
    @RequestMapping("/disableBook/{id}")
    public AjaxResult disableBook(@PathVariable("id") Integer id){
        AjaxResult result = new AjaxResult();
        bookService.disableBook(id);
        result.setSuccess(true);
        return result;
    }

    @ResponseBody
    @RequestMapping("/updateBook")
    public AjaxResult updateBook(Book book,MultipartFile file) throws IOException {
        System.out.println(book);
        AjaxResult result = new AjaxResult();
        bookService.modifyBook(book,file);
        result.setSuccess(true);
        return result;
    }
}
