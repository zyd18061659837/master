package com.itany.service;

import com.itany.pojo.Order;

/**
 * Author:wenlixu
 * Date:2019/4/16 18:27
 * Description:
 * Version:1.0
 */
public interface OrderService {

    String getQrCode(Order order);
}
