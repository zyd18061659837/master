package com.itany.controller;

import com.github.pagehelper.PageInfo;
import com.itany.pojo.Permission;
import com.itany.service.PermissionService;
import com.itany.vo.AjaxResult;
import com.itany.vo.MenuVO;
import com.itany.vo.PermissionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Author:wenlixu
 * Date:2019/4/2 17:12
 * Description:
 * Version:1.0
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/findByConditions")
    @ResponseBody
    public Map<String,Object> findByConditions(PermissionVO permissionVO){
        Map<String,Object> map = new HashMap<>();
        PageInfo<Permission> permissionInfo = permissionService.findByConditions(permissionVO);
        map.put("total",permissionInfo.getTotal());
        map.put("rows",permissionInfo.getList());
        return map;
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Permission> findAll(Permission permission){

        List<Permission> permissions = permissionService.findByIdLikely(permission);
        return permissions;
    }

    @RequestMapping("/findAllModels")
    @ResponseBody
    public List<Permission> findAllModels(){

        List<Permission> permissions = permissionService.findAllModels();
        return permissions;
    }

    @RequestMapping("/modify")
    @ResponseBody
    public AjaxResult modifyPermission(Permission permission){
        AjaxResult result = new AjaxResult();
        permissionService.modifyPermission(permission);
        result.setSuccess(true);
        return result;
    }

    @RequestMapping("/findByUserId/{userId}")
    @ResponseBody
    public Set<MenuVO> findByUserId(@PathVariable("userId") Integer userId){

        Set<MenuVO> permissions = permissionService.findByUserId(userId);
        return permissions;
    }
}
