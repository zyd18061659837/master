package com.itany.controller;

import com.itany.pojo.Press;
import com.itany.pojo.Supplier;
import com.itany.service.PressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:wenlixu
 * Date:2019/4/1 20:25
 * Description:
 * Version:1.0
 */
@Controller
@RequestMapping("/press")
public class PressController  {

    @Autowired
    private PressService pressService;

    @ResponseBody
    @RequestMapping("/findAllPresses")
    private List<Press> findSuppliers(){

        List<Press> presses = pressService.findAll();
        List<Press> list = new ArrayList<>();
        Press temp;
        for(Press press:presses){
            temp = new Press();
            temp.setId(press.getId());
            temp.setName(press.getName());
            list.add(temp);
        }
        return list;

    }
}
