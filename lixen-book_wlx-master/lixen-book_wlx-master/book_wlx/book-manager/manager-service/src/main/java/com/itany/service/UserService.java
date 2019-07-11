package com.itany.service;

import com.github.pagehelper.PageInfo;
import com.itany.exception.UserNotFoundException;
import com.itany.pojo.ManagerUser;
import com.itany.vo.ManagerUserVO;

import java.util.List;

/**
 * Author:wenlixu
 * Date:2019/3/27 14:01
 * Description:
 * Version:1.0
 */
public interface UserService {

    /**
     * 用户登录
     * @param managerUser
     * @return
     */
    ManagerUser login(ManagerUser managerUser) throws UserNotFoundException;

    PageInfo<ManagerUser> findByConditions(ManagerUserVO managerUserVO);

    void addUser(ManagerUserVO managerUserVO);

    void modifyByConditions(ManagerUserVO managerUserVO);
}
