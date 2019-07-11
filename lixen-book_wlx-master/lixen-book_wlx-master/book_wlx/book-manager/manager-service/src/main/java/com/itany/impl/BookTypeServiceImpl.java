package com.itany.impl;

import com.itany.mapper.BookTypeMapper;
import com.itany.pojo.BookType;
import com.itany.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:wenlixu
 * Date:2019/3/27 19:59
 * Description:
 * Version:1.0
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class BookTypeServiceImpl implements BookTypeService {

    @Resource
    private BookTypeMapper typeMapper;

    @Transactional(readOnly = true)
    public List<BookType> findThirdLevelType() {
        List<BookType> types = typeMapper.selectAll();

        List<BookType> thirdTypes = new ArrayList<>();

        for(BookType type:types){
            if(null != type.getParentType() && null != type.getParentType().getParentType()){
                thirdTypes.add(type);
            }
        }

        System.out.println("三级书籍类别是："+thirdTypes);
        return thirdTypes;
    }
}
