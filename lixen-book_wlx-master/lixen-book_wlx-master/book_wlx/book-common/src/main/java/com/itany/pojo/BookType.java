package com.itany.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Author:wenlixu
 * Date:2019/3/27 16:55
 * Description:
 * Version:1.0
 */
@Data
public class BookType implements Serializable {

    private Integer id;

    private String typeText;

    private BookType parentType;

    private List<BookType> children;
}
