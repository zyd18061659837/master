package com.itany.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Author:wenlixu
 * Date:2019/3/27 16:57
 * Description:
 * Version:1.0
 */
@Data
@Accessors(chain = true)
public class Press implements Serializable {

    private Integer id;

    private String name;

    private Integer flag;


}
