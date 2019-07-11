package com.itany.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Author:wenlixu
 * Date:2019/3/27 16:59
 * Description:
 * Version:1.0
 */
@Data
public class Supplier implements Serializable {

    private Integer id;
    private String name;
    private Integer flag;
    private String info;
    private String linkman;
    private String phone;
    private Date createTime;

}
