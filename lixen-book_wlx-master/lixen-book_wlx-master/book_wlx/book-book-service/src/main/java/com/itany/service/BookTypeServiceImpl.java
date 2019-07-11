package com.itany.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.itany.mapper.BookTypeMapper;
import com.itany.pojo.BookType;
import com.itany.vo.SecondType;
import com.itany.vo.Type;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:wenlixu
 * Date:2019/4/17 21:33
 * Description:
 * Version:1.0
 */
@Service
@Component
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Throwable.class)
public class BookTypeServiceImpl implements BookTypeService {

    @Resource
    private BookTypeMapper bookTypeMapper;

    @Override
    public List<BookType> findAll() {

        List<BookType> bookTypes = bookTypeMapper.selectAll();
        System.out.println(bookTypes);

        return bookTypes;
    }

    public Type findForHover(){
        Type type = new Type();

        List<BookType> bookTypes = bookTypeMapper.selectAll();

        //遍历所有一级分类菜单
        for(BookType firstType:bookTypes){
            if(firstType.getTypeText().equals("literature")){

                List<BookType> sons = firstType.getChildren();
                List<SecondType> secondTypes = new ArrayList<>();
                for(BookType son:sons){
                    //获取所有二级分类
                    SecondType secType = new SecondType();
                    secType.setName(son.getTypeText());

                    List<String> grandSonNames = new ArrayList<>();
                    List<BookType> grandsons = son.getChildren();

                    for(BookType grandson:grandsons){
                        //获取所有三级分类名称
                        grandSonNames.add(grandson.getTypeText());
                    }
                    secType.setContext(grandSonNames);
                    secondTypes.add(secType);
                }
                type.setLiterature(secondTypes);
            }

            if(firstType.getTypeText().equals("sciences")){

                List<BookType> sons = firstType.getChildren();
                List<SecondType> secondTypes = new ArrayList<>();
                for(BookType son:sons){
                    //获取所有二级分类
                    SecondType secType = new SecondType();
                    secType.setName(son.getTypeText());

                    List<String> grandSonNames = new ArrayList<>();
                    List<BookType> grandsons = son.getChildren();

                    for(BookType grandson:grandsons){
                        //获取所有三级分类名称
                        grandSonNames.add(grandson.getTypeText());
                    }
                    secType.setContext(grandSonNames);
                    secondTypes.add(secType);
                }
                type.setSciences(secondTypes);
            }

            if(firstType.getTypeText().equals("art")){

                List<BookType> sons = firstType.getChildren();
                List<SecondType> secondTypes = new ArrayList<>();
                for(BookType son:sons){
                    //获取所有二级分类
                    SecondType secType = new SecondType();
                    secType.setName(son.getTypeText());

                    List<String> grandSonNames = new ArrayList<>();
                    List<BookType> grandsons = son.getChildren();

                    for(BookType grandson:grandsons){
                        //获取所有三级分类名称
                        grandSonNames.add(grandson.getTypeText());
                    }
                    secType.setContext(grandSonNames);
                    secondTypes.add(secType);
                }
                type.setArt(secondTypes);
            }

        }




        return type;
    }


}
