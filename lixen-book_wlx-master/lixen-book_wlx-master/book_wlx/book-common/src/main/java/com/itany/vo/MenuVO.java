package com.itany.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Author:wenlixu
 * Date:2019/4/3 9:03
 * Description:
 * Version:1.0
 */
@Data
public class MenuVO implements Serializable {

    private Integer menuid;

    private String icon;

    private String menuname;

    private String url;

    private List<MenuVO> menus;
}
