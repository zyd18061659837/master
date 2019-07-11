package com.itany.vo;

import com.itany.pojo.Book;
import lombok.Data;

import java.io.Serializable;

/**
 * Author:wenlixu
 * Date:2019/3/27 21:37
 * Description:
 * Version:1.0
 */
@Data
public class BookAndSupplierVO extends Book implements Serializable {

    private Integer supplierId;
}
