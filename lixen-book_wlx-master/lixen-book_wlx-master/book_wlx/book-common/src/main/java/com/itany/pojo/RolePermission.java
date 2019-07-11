package com.itany.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Author:wenlixu
 * Date:2019/4/1 22:49
 * Description:
 * Version:1.0
 */
@Data
@Accessors(chain = true)
public class RolePermission implements Serializable {

    private Integer id;
    private Role role;
    private Permission permission;


}
