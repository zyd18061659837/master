package com.itany.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Author:wenlixu
 * Date:2019/4/10 11:20
 * Description:
 * Version:1.0
 */
@Data
@Accessors(chain = true)
public class User implements Serializable {

    private Integer id;
    private String username;
    private String phone;
    private String email;
    private String interest;
    private String password;
    private Integer flag;

}
