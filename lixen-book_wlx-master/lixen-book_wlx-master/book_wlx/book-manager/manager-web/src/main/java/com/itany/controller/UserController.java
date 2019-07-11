package com.itany.controller;

import com.github.pagehelper.PageInfo;
import com.itany.exception.UserNotFoundException;
import com.itany.pojo.Book;
import com.itany.pojo.ManagerUser;
import com.itany.service.UserService;
import com.itany.vo.AjaxResult;
import com.itany.vo.BookVO;
import com.itany.vo.ManagerUserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:wenlixu
 * Date:2019/3/27 14:19
 * Description:
 * Version:1.0
 */
@Controller
@RequestMapping("/user")
//@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/login")
    public AjaxResult login(ManagerUser managerUser, HttpSession session) throws UserNotFoundException {
        AjaxResult result = new AjaxResult();
        ManagerUser retManagerUser =userService.login(managerUser);

//        SecurityManager securityManager = SecurityUtils.getSecurityManager();
//        securityManager.getSession().setAttribute();

        //密码置空
        retManagerUser.setPassword(null);
        session.setAttribute("user", retManagerUser);
        result.setSuccess(true);
        return result;
    }


    @ResponseBody
    @RequestMapping("/findByConditions")
    public Map<String,Object> findByConditions(ManagerUserVO managerUserVO){

        Map<String,Object> map = new HashMap<>();
        PageInfo<ManagerUser> userPageInfo = userService.findByConditions(managerUserVO);
        map.put("rows",userPageInfo.getList());
        map.put("total",userPageInfo.getTotal());
        return map;
    }

    @ResponseBody
    @RequestMapping("/add")
    public AjaxResult addUser(ManagerUserVO vo){
        AjaxResult result = new AjaxResult();
        userService.addUser(vo);
        result.setSuccess(true);
        return result;
    }

    @ResponseBody
    @RequestMapping("/modify")
    public AjaxResult modify(ManagerUserVO vo){
        AjaxResult result = new AjaxResult();
        userService.modifyByConditions(vo);
        result.setSuccess(true);
        return result;
    }

}
