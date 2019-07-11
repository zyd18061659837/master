package com.itany.vo;

import com.itany.pojo.Examine;
import lombok.Data;

import java.io.Serializable;

/**
 * Author:wenlixu
 * Date:2019/3/29 15:39
 * Description:
 * Version:1.0
 */
@Data
public class ExamineVO  extends Examine implements Serializable
{

    private Integer page;

    private Integer rows;

    private String bookName;

    private String ISBN;
}
