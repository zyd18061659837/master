package com.itany.service;

import com.github.pagehelper.PageInfo;
import com.itany.pojo.Permission;
import com.itany.vo.MenuVO;
import com.itany.vo.PermissionVO;

import java.util.List;
import java.util.Set;

/**
 * Author:wenlixu
 * Date:2019/4/2 17:07
 * Description:
 * Version:1.0
 */
public interface PermissionService {

    PageInfo<Permission> findByConditions(PermissionVO permissionVO);

    List<Permission> findByIdLikely(Permission permission);


    List<Permission> findAllModels();

    void modifyPermission(Permission permission);

    Set<MenuVO> findByUserId(Integer userId);



}
