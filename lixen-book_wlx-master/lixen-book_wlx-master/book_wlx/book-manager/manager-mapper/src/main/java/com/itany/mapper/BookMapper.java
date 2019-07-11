package com.itany.mapper;

import com.itany.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author:wenlixu
 * Date:2019/3/27 21:33
 * Description:
 * Version:1.0
 */
public interface BookMapper {

    /**
     * 添加book
     * @param book
     */
    void insertBook(Book book);

    /**
     * 根据ISBN查询书本信息
     * @param ISBN
     * @return
     */
    Book selectByISBN(String ISBN);

    /**
     * 根据差量修改书本的数量
     * @param numberDelta
     */
    void updateForNumber(@Param("id") Integer id, @Param("numberDelta") Integer numberDelta);

    /**
     * 根据id查询book
     * @param id
     * @return
     */
    Book selectById(@Param("id") Integer id);

    /**
     * 根据条件修改book
     * @param book
     */
    void updateByConditions(Book book);

    /**
     * 根据条件进行查询
     * @param book
     * @return
     */
    List<Book> selectByConditions(Book book);

}
