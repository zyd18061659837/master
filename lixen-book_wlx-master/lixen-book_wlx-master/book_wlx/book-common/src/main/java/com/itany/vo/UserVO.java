package com.itany.vo;

import com.itany.pojo.User;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Author:wenlixu
 * Date:2019/4/11 14:58
 * Description:
 * Version:1.0
 */
@Data
@Accessors(chain = true)
public class UserVO extends User {

    private String code;
}
