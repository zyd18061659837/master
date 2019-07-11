package com.itany.mapper;

import com.itany.pojo.Examine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author:wenlixu
 * Date:2019/3/29 10:25
 * Description:
 * Version:1.0
 */
public interface ExamineMapper {

    void insertExamine(Examine examine);

    List<Examine> selectBySupplier(Examine examine);

    Examine selectById(@Param("id") Integer id);

    void updateByConditions(Examine examine);
}
