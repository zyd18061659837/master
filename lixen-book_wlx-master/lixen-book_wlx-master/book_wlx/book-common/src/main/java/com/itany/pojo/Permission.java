package com.itany.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * Author:wenlixu
 * Date:2019/4/1 22:50
 * Description:
 * Version:1.0
 */
@Data
@Accessors(chain = true)
public class Permission implements Serializable {

    private Integer id;
    private String name;
    private Permission parent;
    private Integer parentId;
    private String sName;
    private String url;

    private List<Permission> children;
}
