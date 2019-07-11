package com.itany.mapper;

import com.itany.pojo.UserRole;
import org.apache.ibatis.annotations.Param;

/**
 * Author:wenlixu
 * Date:2019/4/2 11:25
 * Description:
 * Version:1.0
 */
public interface UserRoleMapper {

    void insertUserRole(UserRole userRole);

    void deleteByUserId(@Param("managerUserId") Integer userId);
}
