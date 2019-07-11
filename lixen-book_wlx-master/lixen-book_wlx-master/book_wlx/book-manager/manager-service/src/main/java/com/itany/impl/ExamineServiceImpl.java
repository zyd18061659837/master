package com.itany.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itany.constant.Constants;
import com.itany.mapper.BookMapper;
import com.itany.mapper.BookSupplierMapper;
import com.itany.mapper.ExamineMapper;
import com.itany.pojo.Book;
import com.itany.pojo.BookSupplier;
import com.itany.pojo.Examine;
import com.itany.service.ExamineService;
import com.itany.vo.ExamineVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author:wenlixu
 * Date:2019/3/29 14:45
 * Description:
 * Version:1.0
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Throwable.class)
public class ExamineServiceImpl implements ExamineService {

    @Resource
    private ExamineMapper examineMapper;

    @Resource
    private BookMapper bookMapper;

    @Resource
    private BookSupplierMapper bookSupplierMapper;

    @Override
    public PageInfo<Examine> findExamineBySupplier(ExamineVO examineVO) {

        PageHelper.startPage(examineVO.getPage(),examineVO.getRows());

        List<Examine> examines = examineMapper.selectBySupplier(examineVO);

        PageInfo<Examine> examinePageInfo = new PageInfo<>(examines);

        return examinePageInfo;
    }

    @Override
    public void startToExamine(Examine examine) {

        //获取此次供应上提供的书本number
        Examine retExamine = examineMapper.selectById(examine.getId());
        Book book = retExamine.getBook();
        int number = retExamine.getNumber();

        //更新审核表的状态
        examineMapper.updateByConditions(examine);

        //根据flag来判断审核是否通过 ？？安全问题？？
        Integer flag = examine.getFlag();

        //如果通过审核，book中number数量增加，如果第一次添加该书籍，还需要将相关书籍中的flag变为1
        //如果是该供应上第一次添加该书籍，添加t_supplier_book记录，否则 修改其
        if(flag.equals(Constants.ExaminationStatus.SUCCESS.getValue())){
            Integer bookFlag = book.getFlag();

            //书籍原本是未审核状态,即第一次添加该书籍 或者是未通过审核状态
            if(bookFlag.equals(Constants.ExaminationStatus.AWAIT.getValue())
                    || book.getFlag().equals(Constants.ExaminationStatus.FAILURE.getValue())){
                book.setFlag(Constants.ExaminationStatus.SUCCESS.getValue());
                book.setNumber(book.getNumber()+number);
                bookMapper.updateByConditions(book);

                BookSupplier bookSupplier = new BookSupplier();

                bookSupplier.setSupplierId(retExamine.getSupplierId());
                bookSupplier.setBookId(book.getId());

                bookSupplier.setNumber(number);
                System.out.println(bookSupplier);
                bookSupplierMapper.insertBookSupplier(bookSupplier);

            }

            if(bookFlag.equals(Constants.ExaminationStatus.SUCCESS.getValue())){

                //书籍原本是已通过审核状态
                book.setNumber(book.getNumber()+number);
                bookMapper.updateByConditions(book);
                
                BookSupplier bookSupplier = new BookSupplier();
                bookSupplier.setBookId(book.getId());
                bookSupplier.setSupplierId(retExamine.getSupplierId());
                BookSupplier bookSupplierNeedToChange = bookSupplierMapper.selectByBookIdAndSupplierId(bookSupplier);
                bookSupplierNeedToChange.setNumber(bookSupplierNeedToChange.getNumber()+number);
                bookSupplierMapper.updateForNumberOrSellNumById(bookSupplierNeedToChange);
            }
//            //书籍原本是未通过审核状态
//            if(book.getFlag().equals(Constants.ExaminationStatus.FAILURE.getValue())){
//                book.setFlag(Constants.ExaminationStatus.SUCCESS.getValue());
//                book.setNumber(book.getNumber()+number);
//                bookMapper.updateByConditions(book);

//                BookSupplier bookSupplier = new BookSupplier();
//                bookSupplier.setSupplierId(examine.getId());
//                bookSupplier.setBookId(book.getId());
//                bookSupplier.setNumber(number);
//                bookSupplierMapper.insertBookSupplier(bookSupplier);
//            }

        }

//        //如果审核未通过，只需要改变审核表的状态。上面已完成
//        if(flag.equals(Constants.ExaminationStatus.FAILURE.getValue())){
//
//        }


    }
}
