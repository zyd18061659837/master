package com.itany.mapper;

import com.itany.pojo.Permission;
import com.itany.vo.MenuVO;
import com.itany.vo.PermissionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author:wenlixu
 * Date:2019/4/2 16:51
 * Description:
 * Version:1.0
 */
public interface PermissionMapper  {

    List<Permission> selectByConditions(PermissionVO permissionVO);

    List<Permission> selectByIdLikely(Permission permission);

    List<Permission> selectAllParentPermissions();

    List<MenuVO> selectByUserId(@Param("userId") Integer userId);

    void updateByConditions(Permission permission);


}
