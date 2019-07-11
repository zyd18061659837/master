package com.itany.impl;

import com.itany.constant.Constants;
import com.itany.mapper.PressMapper;
import com.itany.pojo.Press;
import com.itany.service.PressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author:wenlixu
 * Date:2019/4/1 20:23
 * Description:
 * Version:1.0
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class PressServiceImpl implements PressService {

    @Resource
    private PressMapper pressMapper;

    @Override
    public List<Press> findAll() {

        List<Press> presses = pressMapper.selectAll(Constants.Status.ENABLE.getValue());

        return presses;
    }
}
