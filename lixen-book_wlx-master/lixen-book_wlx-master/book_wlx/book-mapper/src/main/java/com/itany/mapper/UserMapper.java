package com.itany.mapper;

import com.itany.pojo.User;

/**
 * Author:wenlixu
 * Date:2019/4/10 11:32
 * Description:
 * Version:1.0
 */
public interface UserMapper {

    User selectByUsernameAndPassword(User user);

    User selectByUsername(User user);

    void insertUser(User user);

}
