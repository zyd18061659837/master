package com.itany.controller;

import com.itany.pojo.Supplier;
import com.itany.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:wenlixu
 * Date:2019/3/31 16:55
 * Description:
 * Version:1.0
 */
@RequestMapping("/supplier")
@Controller
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @ResponseBody
    @RequestMapping("/findAllSuppliers")
    private List<Supplier> findSuppliers(){

        List<Supplier> suppliers = supplierService.findAll();
        List<Supplier> list = new ArrayList<>();
        Supplier temp;
        for(Supplier supplier:suppliers){
            temp = new Supplier();
            temp.setId(supplier.getId());
            temp.setName(supplier.getName());
            list.add(temp);
        }
        return list;

    }
}
