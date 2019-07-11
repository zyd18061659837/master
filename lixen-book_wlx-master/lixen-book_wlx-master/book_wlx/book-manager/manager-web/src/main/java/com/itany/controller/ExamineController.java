package com.itany.controller;

import com.github.pagehelper.PageInfo;
import com.itany.pojo.Examine;
import com.itany.service.ExamineService;
import com.itany.vo.AjaxResult;
import com.itany.vo.ExamineVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:wenlixu
 * Date:2019/3/29 15:36
 * Description:
 * Version:1.0
 */
@Controller
@RequestMapping("/examine")
public class ExamineController {

    @Autowired
    private ExamineService examineService;

    @ResponseBody
    @RequestMapping("/findBySupplierId/{supplierId}")
    public Map<String,Object> findExamines(ExamineVO examineVO,@PathVariable("supplierId") Integer supplierId){

        examineVO.setSupplierId(supplierId);
        System.out.println(examineVO);

        PageInfo<Examine> examinePageInfo = examineService.findExamineBySupplier(examineVO);

        Map<String,Object> map = new HashMap<>();
        map.put("total",examinePageInfo.getTotal());
        map.put("rows",examinePageInfo.getList());
        return map;
    }

    @ResponseBody
    @RequestMapping("/findBySupplier")
    public Map<String,Object> findAllExamines(ExamineVO examineVO){

        PageInfo<Examine> examinePageInfo = examineService.findExamineBySupplier(examineVO);

        Map<String,Object> map = new HashMap<>();
        map.put("rows",examinePageInfo.getList());
        map.put("total",examinePageInfo.getTotal());
        return map;
    }

    @ResponseBody
    @RequestMapping("/startToExamine")
    public AjaxResult startToExamine(Examine examine){
        AjaxResult ajaxResult = new AjaxResult();

        examineService.startToExamine(examine);
        ajaxResult.setSuccess(true);

        return ajaxResult;
    }

}
