package com.itany.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Author:wenlixu
 * Date:2019/4/1 22:47
 * Description:
 * Version:1.0
 */
@Data
@Accessors(chain = true)
public class UserRole implements Serializable {

    private Integer id;
    private ManagerUser managerUser;
    private Role role;
}
