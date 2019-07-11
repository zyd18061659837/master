package com.itany.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itany.mapper.RoleMapper;
import com.itany.mapper.RolePermissionMapper;
import com.itany.pojo.Permission;
import com.itany.pojo.Role;
import com.itany.pojo.RolePermission;
import com.itany.service.RoleService;
import com.itany.vo.RoleVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author:wenlixu
 * Date:2019/4/1 22:57
 * Description:
 * Version:1.0
 */

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Throwable.class)
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public PageInfo<Role> findByConditions(RoleVO roleVO) {

        PageHelper.startPage(roleVO.getPage(),roleVO.getRows());
        List<Role> roles = roleMapper.selectByConditions(roleVO);
        PageInfo<Role> rolePageInfo = new PageInfo<>(roles);
        return rolePageInfo;
    }

    @Override
    public void modifyRole(RoleVO roleVO) {

        String[] permissionIds = roleVO.getPermissionIds()
                .substring(0,roleVO.getPermissionIds().length()-1)
                .split(",");

        roleMapper.updateByConditions(roleVO);

        rolePermissionMapper.deleteByRoleId(roleVO.getId());

        for(String permissionId:permissionIds){

            RolePermission rolePermission = new RolePermission();

            Permission permission = new Permission()
                    .setId(Integer.parseInt(permissionId));
            rolePermission.setRole(roleVO).setPermission(permission);

            rolePermissionMapper.insertRolePermission(rolePermission);
        }
    }

    @Override
    public void removeRoleById(Integer id) {

        rolePermissionMapper.deleteByRoleId(id);
        roleMapper.deleteById(id);
    }

    @Override
    public List<Role> findAll() {

        List<Role> roles = roleMapper.selectAll();

        return roles;
    }

}
