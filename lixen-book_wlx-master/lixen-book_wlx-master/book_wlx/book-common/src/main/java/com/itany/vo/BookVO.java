package com.itany.vo;

import com.itany.pojo.Book;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Author:wenlixu
 * Date:2019/4/1 16:25
 * Description:
 * Version:1.0
 */
@Data
public class BookVO extends Book implements Serializable {

    private Integer page;

    private Integer rows;

    private Integer total;

    Set<Map<String, String>> bookList;


}
