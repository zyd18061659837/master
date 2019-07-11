package com.itany.service;

import com.github.pagehelper.PageInfo;
import com.itany.pojo.Examine;
import com.itany.vo.ExamineVO;

import java.util.List;

/**
 * Author:wenlixu
 * Date:2019/3/29 10:04
 * Description:
 * Version:1.0
 */
public interface ExamineService {


    /**
     * 根据条件查询所有的审核信息
     * @param examineVO
     * @return
     */
    PageInfo<Examine> findExamineBySupplier(ExamineVO examineVO);

    /**
     * 开始审核
     * @param examine
     */
    void startToExamine(Examine examine);
}
