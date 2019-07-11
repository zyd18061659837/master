package com.itany.mapper;

import com.itany.pojo.RolePermission;
import org.apache.ibatis.annotations.Param;

/**
 * Author:wenlixu
 * Date:2019/4/2 21:12
 * Description:
 * Version:1.0
 */
public interface RolePermissionMapper {

    void insertRolePermission(RolePermission rolePermission);

    void deleteByRoleId(@Param("roleId") Integer roleId);

}
