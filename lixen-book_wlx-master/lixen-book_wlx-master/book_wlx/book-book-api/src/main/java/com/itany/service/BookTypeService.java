package com.itany.service;

import com.itany.pojo.BookType;
import com.itany.vo.SecondType;
import com.itany.vo.Type;

import java.util.List;
import java.util.Map;

/**
 * Author:wenlixu
 * Date:2019/4/17 21:32
 * Description:
 * Version:1.0
 */
public interface BookTypeService {

    List<BookType> findAll();

    Type findForHover();

}
