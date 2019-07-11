package com.itany.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * Author:wenlixu
 * Date:2019/3/27 17:04
 * Description:
 * Version:1.0
 */
@Data
public class Examine implements Serializable {


    private Integer id;
    private Book book;
    private Integer number;
    private String info;
    private Supplier supplier;
    private Integer supplierId;
    private String title;
    private Integer flag;


}
