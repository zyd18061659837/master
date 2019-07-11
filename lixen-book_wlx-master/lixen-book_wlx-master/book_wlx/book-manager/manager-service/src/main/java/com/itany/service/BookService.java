package com.itany.service;

import com.github.pagehelper.PageInfo;
import com.itany.pojo.Book;
import com.itany.vo.BookAndSupplierVO;
import com.itany.vo.BookVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Author:wenlixu
 * Date:2019/3/27 18:23
 * Description:
 * Version:1.0
 */
public interface BookService {

    void addToCheck(BookAndSupplierVO bookAndSupplierVO, MultipartFile file) throws IOException;

    Book findById(Integer id);

    PageInfo<Book> findByConditions(BookVO vo);

    void modifyBook(Book book,MultipartFile file) throws IOException;

    void enableBook(Integer id);

    void disableBook(Integer id);
}
