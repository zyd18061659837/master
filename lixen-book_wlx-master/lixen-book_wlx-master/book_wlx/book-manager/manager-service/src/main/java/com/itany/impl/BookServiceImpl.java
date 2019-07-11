package com.itany.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itany.constant.Constants;
import com.itany.mapper.BookMapper;
import com.itany.mapper.ExamineMapper;
import com.itany.pojo.Book;
import com.itany.pojo.Examine;
import com.itany.pojo.Supplier;
import com.itany.service.BookService;
import com.itany.vo.BookAndSupplierVO;
import com.itany.vo.BookVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Author:wenlixu
 * Date:2019/3/27 18:47
 * Description:
 * Version:1.0
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;

    @Resource
    private ExamineMapper examineMapper;


    public void addToCheck(BookAndSupplierVO bookAndSupplierVO, MultipartFile file) throws IOException {

        //判断该书籍是否曾今上传过
        Book book = bookMapper.selectByISBN(bookAndSupplierVO.getISBN());

        Integer number = bookAndSupplierVO.getNumber();
        bookAndSupplierVO.setNumber(0);

        if(null != book){
            //添加t_examine表 修改book表中的number数量
//            bookMapper.updateForNumber(book.getId(),bookAndSupplierVO.getNumber());

            Examine examine = new Examine();
            Supplier supplierToExam = new Supplier();

            examine.setBook(book);
            examine.setNumber(number);
            examine.setSupplier(supplierToExam);
            examine.setTitle("["+book.getBookName()+"] 审核");
            examine.setFlag(Constants.ExaminationStatus.AWAIT.getValue());

            supplierToExam.setId(bookAndSupplierVO.getSupplierId());
            examineMapper.insertExamine(examine);


        } else {
            //添加t_book表 和 t_examine表


            bookAndSupplierVO.setCreateTime(new Date());
            bookAndSupplierVO.setFlag(Constants.ExaminationStatus.AWAIT.getValue());
            String imageFolder = "D:/tomcat8/apache-tomcat-8.5.39/webapps/image/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String imgUrl = "/image/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"/"+file.getOriginalFilename();
            bookAndSupplierVO.setImgUrl(imgUrl);

            //添加book
            bookMapper.insertBook(bookAndSupplierVO);


            //添加t_examine表
            Examine examine = new Examine();
            Book bookToExam =new Book();
            bookToExam.setId(bookAndSupplierVO.getId());
            examine.setBook(bookToExam);
            examine.setFlag(Constants.ExaminationStatus.AWAIT.getValue());
            examine.setNumber(number);
            Supplier supplierToExam = new Supplier();
            supplierToExam.setId(bookAndSupplierVO.getSupplierId());
            examine.setSupplier(supplierToExam);
            examine.setTitle("["+bookAndSupplierVO.getBookName()+"] 审核");
            examineMapper.insertExamine(examine);

            //上传文件到指定服务器
            File imageFileFolder = new File(imageFolder);
            imageFileFolder.mkdirs();

            if(null != file && !file.isEmpty()){
                file.transferTo(new File(imageFolder+File.separator+file.getOriginalFilename()));
            }

        }
    }

    @Transactional(readOnly = true)
    @Override
    public Book findById(Integer id) {

        Book book = bookMapper.selectById(id);

        return book;
    }

    @Transactional(readOnly = true)
    @Override
    public PageInfo<Book> findByConditions(BookVO vo) {

        PageHelper.startPage(vo.getPage(),vo.getRows());

        List<Book> books = bookMapper.selectByConditions(vo);

        PageInfo<Book> bookPageInfo = new PageInfo<>(books);


        return bookPageInfo;
    }

    @Override
    public void modifyBook(Book book, MultipartFile file) throws IOException {


        String imgUrl = "/image/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"/"+file.getOriginalFilename();
        String imageFolder = "D:/tomcat8/apache-tomcat-8.5.39/webapps/image/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        book.setImgUrl(imgUrl);

        bookMapper.updateByConditions(book);

        new File(imageFolder).mkdirs();

        if(null != file && !file.isEmpty()){
            file.transferTo(new File(imageFolder+File.separator+file.getOriginalFilename()));
        }


    }

    @Override
    public void enableBook(Integer id) {
        Book toEnable = new Book();
        toEnable.setId(id);
        toEnable.setFlag(Constants.ExaminationStatus.SUCCESS.getValue());
        Book book = bookMapper.selectById(id);
        if(book.getFlag().equals(Constants.ExaminationStatus.SUCCESS.getValue())){
//            throw new
        }else{
            bookMapper.updateByConditions(toEnable);
        }

    }

    @Override
    public void disableBook(Integer id) {
        Book toDisable = new Book();
        toDisable.setFlag(Constants.ExaminationStatus.FAILURE.getValue());
        toDisable.setId(id);
        Book book = bookMapper.selectById(id);

        if(book.getFlag().equals(Constants.ExaminationStatus.FAILURE.getValue())){
//            throw new
        }else{
            bookMapper.updateByConditions(toDisable);
        }
    }
}
