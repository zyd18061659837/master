package com.itany.controller;

import com.itany.pojo.BookType;
import com.itany.service.BookTypeService;
import com.itany.vo.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author:wenlixu
 * Date:2019/3/27 20:31
 * Description:
 * Version:1.0
 */
@Controller
@RequestMapping("/bookType")
public class BookTypeController {

    @Autowired
    private BookTypeService bookTypeService;

    @ResponseBody
    @RequestMapping("/findThirdLevelTypes")
    public AjaxResult findThirdLevelTypes(){
        AjaxResult result = new AjaxResult();

        List<BookType> thirdLevelTypes = bookTypeService.findThirdLevelType();
        result.setSuccess(true);
        result.setData(thirdLevelTypes);

        return result;
    }


}
