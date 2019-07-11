package com.itany.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itany.mapper.PermissionMapper;
import com.itany.pojo.Permission;
import com.itany.service.PermissionService;
import com.itany.vo.MenuVO;
import com.itany.vo.PermissionVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author:wenlixu
 * Date:2019/4/2 17:09
 * Description:
 * Version:1.0
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Throwable.class)
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Transactional(readOnly = true)
    @Override
    public PageInfo<Permission> findByConditions(PermissionVO permissionVO) {

        PageHelper.startPage(permissionVO.getPage(),permissionVO.getRows());
        List<Permission> permissions = permissionMapper.selectByConditions(permissionVO);
        PageInfo<Permission> permissionPageInfo = new PageInfo<>(permissions);
        return permissionPageInfo;
    }

    @Override
    public List<Permission> findByIdLikely(Permission permission) {

        List<Permission> permissions = permissionMapper.selectByIdLikely(permission);

        List<Permission> rightPermissions = new ArrayList<>();
        for(Permission temp:permissions){
            if(!temp.getChildren().isEmpty()){
                rightPermissions.add(temp);
            }
        }

        return rightPermissions;
    }

    @Override
    public List<Permission> findAllModels() {
        List<Permission> permissions = permissionMapper.selectAllParentPermissions();
        return permissions;
    }

    @Override
    public void modifyPermission(Permission permission) {

        permissionMapper.updateByConditions(permission);

    }

    @Override
    public Set<MenuVO> findByUserId(Integer userId) {

        List<MenuVO> permissions = permissionMapper.selectByUserId(userId);

        List<Integer> ids = new ArrayList<>();
        for(MenuVO temp:permissions){
            ids.add(temp.getMenuid());
        }

        Set<MenuVO> rightPermissions = new HashSet<>();
        for(MenuVO temp:permissions){
            if(!temp.getMenus().isEmpty()){
                //获取所有一级菜单中的二级权限名称
                List<MenuVO> list = temp.getMenus();
                for(int i = list.size()-1;i>=0;i--){
                    if(!ids.contains(list.get(i).getMenuid())){
                        list.remove(i);
                    }
                }

                rightPermissions.add(temp);
            }
        }

        return rightPermissions;
    }


}
