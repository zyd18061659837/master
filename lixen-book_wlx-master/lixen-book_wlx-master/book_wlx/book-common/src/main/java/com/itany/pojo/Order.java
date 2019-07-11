package com.itany.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Author:wenlixu
 * Date:2019/4/16 21:38
 * Description:
 * Version:1.0
 */
@Data
@Accessors(chain = true)
public class Order implements Serializable {

    private Integer id;
    private String no;
    private String alipayNo;
    private User user;
    private Integer addressId;
    private String info;
    private Double price;
    private Integer flag;

}
