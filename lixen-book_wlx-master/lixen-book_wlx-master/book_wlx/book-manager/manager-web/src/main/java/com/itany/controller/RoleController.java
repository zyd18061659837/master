package com.itany.controller;

import com.github.pagehelper.PageInfo;
import com.itany.pojo.Role;
import com.itany.service.RoleService;
import com.itany.vo.AjaxResult;
import com.itany.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:wenlixu
 * Date:2019/4/1 22:59
 * Description:
 * Version:1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping("/findAll")
    private List<Role>  findAll(){

        List<Role> roles = roleService.findAll();

        return roles;
    }

    @ResponseBody
    @RequestMapping("/findByConditions")
    private Map<String,Object> findByConditions(RoleVO roleVO){
        Map<String,Object> map = new HashMap<>();
        PageInfo<Role> rolePageInfo = roleService.findByConditions(roleVO);

        map.put("total",rolePageInfo.getTotal());
        map.put("rows",rolePageInfo.getList());

        System.out.println(map);
        return map;
    }

    @ResponseBody
    @RequestMapping("/modify")
    public AjaxResult modifyRole(RoleVO roleVO){
        AjaxResult result = new AjaxResult();
        roleService.modifyRole(roleVO);
        result.setSuccess(true);
        return result;
    }

    @ResponseBody
    @RequestMapping("/delete/{id}")
    public AjaxResult modifyRole(@PathVariable("id") Integer id){
        AjaxResult result = new AjaxResult();
        roleService.removeRoleById(id);
        result.setSuccess(true);
        return result;
    }

}
