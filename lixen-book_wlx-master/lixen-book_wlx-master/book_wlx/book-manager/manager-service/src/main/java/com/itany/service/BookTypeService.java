package com.itany.service;

import com.itany.pojo.BookType;

import java.util.List;

/**
 * Author:wenlixu
 * Date:2019/3/27 18:46
 * Description:
 * Version:1.0
 */
public interface BookTypeService {

    /**
     * 查找所有的三级书籍类别
     * @return
     */
    List<BookType> findThirdLevelType();


}
