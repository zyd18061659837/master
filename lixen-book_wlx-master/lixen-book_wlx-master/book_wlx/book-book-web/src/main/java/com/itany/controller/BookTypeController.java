package com.itany.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itany.pojo.BookType;
import com.itany.service.BookTypeService;
import com.itany.vo.Type;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Author:wenlixu
 * Date:2019/4/17 21:36
 * Description:
 * Version:1.0
 */
@Controller
@RequestMapping("/showIndex")
public class BookTypeController {

    @Reference
    private BookTypeService bookTypeService;

    @RequestMapping("")
    public String findAllTypes(Model model){

        List<BookType> bookTypes = bookTypeService.findAll();
        Type types = bookTypeService.findForHover();
        String typesJson = JSON.toJSONString(types);
        model.addAttribute("bookTypes",bookTypes);
        model.addAttribute("types",typesJson);

        return "index";
    }

}
