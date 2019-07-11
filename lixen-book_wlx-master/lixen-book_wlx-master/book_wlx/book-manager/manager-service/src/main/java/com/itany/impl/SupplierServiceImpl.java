package com.itany.impl;

import com.itany.constant.Constants;
import com.itany.mapper.SupplierMapper;
import com.itany.pojo.Supplier;
import com.itany.service.SupplierService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author:wenlixu
 * Date:2019/3/31 14:18
 * Description:
 * Version:1.0
 */

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class SupplierServiceImpl implements SupplierService {

    @Resource
    private SupplierMapper supplierMapper;

    @Override
    public List<Supplier> findAll() {

        List<Supplier> suppliers = supplierMapper.selectByFlag(Constants.Status.ENABLE.getValue());

        return suppliers;
    }
}
