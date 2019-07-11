package com.itany.service;

import com.github.pagehelper.PageInfo;
import com.itany.pojo.Role;
import com.itany.vo.RoleVO;

import java.util.List;

/**
 * Author:wenlixu
 * Date:2019/4/1 22:56
 * Description:
 * Version:1.0
 */
public interface RoleService {

    List<Role> findAll();


    PageInfo<Role> findByConditions(RoleVO roleVO);

    void modifyRole(RoleVO roleVO);

    void removeRoleById(Integer id);
}
