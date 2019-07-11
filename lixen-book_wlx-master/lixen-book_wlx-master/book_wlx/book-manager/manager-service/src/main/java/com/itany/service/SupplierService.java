package com.itany.service;

import com.itany.pojo.Supplier;

import java.util.List;

/**
 * Author:wenlixu
 * Date:2019/3/31 14:15
 * Description:
 * Version:1.0
 */
public interface SupplierService {

    /**
     * 查询所有的供应商
     * @return
     */
    List<Supplier> findAll();
}
