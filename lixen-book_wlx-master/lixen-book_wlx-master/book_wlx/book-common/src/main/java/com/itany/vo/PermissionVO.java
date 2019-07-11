package com.itany.vo;

import com.itany.pojo.Permission;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Author:wenlixu
 * Date:2019/4/2 17:07
 * Description:
 * Version:1.0
 */
@Data
@Accessors(chain = true)
public class PermissionVO extends Permission implements Serializable {

    private Integer page;
    private Integer rows;

    private String parentName;
}
