package com.itany.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Author:wenlixu
 * Date:2019/3/27 16:44
 * Description:
 * Version:1.0
 */
@Data
public class Book implements Serializable {

    private Integer id;
    private String bookName;
    private String author;
    private Date publishDate;
    private Double groupPrice;
    private Double price;
    private String format;
    private Integer pageNumber;
    private String ISBN;
    private String barcode;
    private String layout;
    private Integer printingNumber;
    private String register;
    private String weight;
    private String bookIntroduce;
    private String authorIntroduce;
    private String catalog;
    private Integer typeId;
    private BookType bookType;
    private Date createTime;

    private Integer pressId;
    private Press press;
    private Integer number;
    private String imgUrl;
    private Integer flag;
    private Integer recommend;

    private String supplierName;
    private Supplier supplier;
    private Integer supplierId;

}
