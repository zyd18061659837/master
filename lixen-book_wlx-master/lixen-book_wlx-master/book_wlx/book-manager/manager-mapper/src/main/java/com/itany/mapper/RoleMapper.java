package com.itany.mapper;

import com.itany.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author:wenlixu
 * Date:2019/4/1 22:54
 * Description:
 * Version:1.0
 */
public interface RoleMapper {

    List<Role> selectAll();
    List<Role> selectByConditions(Role role);
    void updateByConditions(Role role);

    void deleteById(@Param("id") Integer id);
}
