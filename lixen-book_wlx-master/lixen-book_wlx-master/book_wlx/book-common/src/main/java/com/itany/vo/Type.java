package com.itany.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Author:wenlixu
 * Date:2019/4/17 22:49
 * Description:
 * Version:1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Type implements Serializable {

    private List<SecondType> literature;
    private List<SecondType> sciences;
    private List<SecondType> juvenile;
    private List<SecondType> art;
    private List<SecondType> life;
    private List<SecondType> culture;

}
