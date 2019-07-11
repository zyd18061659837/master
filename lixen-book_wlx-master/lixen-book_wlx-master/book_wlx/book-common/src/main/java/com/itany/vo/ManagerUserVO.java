package com.itany.vo;

import com.itany.pojo.ManagerUser;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Author:wenlixu
 * Date:2019/4/1 23:16
 * Description:
 * Version:1.0
 */
@Data
@Accessors(chain = true)
public class ManagerUserVO extends ManagerUser implements Serializable {

    private Integer page;
    private Integer rows;
    private String ids;
}
