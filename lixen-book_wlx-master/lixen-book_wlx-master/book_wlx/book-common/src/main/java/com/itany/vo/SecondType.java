package com.itany.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Author:wenlixu
 * Date:2019/4/17 22:24
 * Description:
 * Version:1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecondType implements Serializable {
    private String name;
    private List<String> context;

}
