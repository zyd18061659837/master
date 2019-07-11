package com.itany.vo;

import com.itany.pojo.Role;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Author:wenlixu
 * Date:2019/4/2 14:53
 * Description:
 * Version:1.0
 */
@Data
@Accessors(chain = true)
public class RoleVO extends Role implements Serializable {

    private Integer page;

    private Integer rows;

    private String permissionIds;


}
