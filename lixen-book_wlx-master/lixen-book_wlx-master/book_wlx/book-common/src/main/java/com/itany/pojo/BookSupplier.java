package com.itany.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * Author:wenlixu
 * Date:2019/3/27 17:01
 * Description:
 * Version:1.0
 */
@Data
public class BookSupplier implements Serializable {

    private Integer id;
    private Book book;
    private Integer bookId;
    private Integer supplierId;
    private Supplier supplier;
    private Integer sellNum;
    private Integer number;
}
