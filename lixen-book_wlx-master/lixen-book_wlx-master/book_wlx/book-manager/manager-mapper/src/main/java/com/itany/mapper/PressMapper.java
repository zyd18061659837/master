package com.itany.mapper;

import com.itany.pojo.Press;

import java.util.List;

/**
 * Author:wenlixu
 * Date:2019/4/1 20:19
 * Description:
 * Version:1.0
 */
public interface PressMapper {

    List<Press> selectAll(Integer flag);
}
