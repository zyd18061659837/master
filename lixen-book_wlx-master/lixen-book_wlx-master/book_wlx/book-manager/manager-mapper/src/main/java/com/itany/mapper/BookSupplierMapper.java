package com.itany.mapper;

import com.itany.pojo.BookSupplier;

/**
 * Author:wenlixu
 * Date:2019/3/29 10:55
 * Description:
 * Version:1.0
 */
public interface BookSupplierMapper {

    /**
     * 添加book_supplier表数据
     * @param bookSupplier
     */
    void insertBookSupplier(BookSupplier bookSupplier);

    void updateForNumberOrSellNumById(BookSupplier bookSupplier);

    BookSupplier selectByBookIdAndSupplierId(BookSupplier bookSupplier);

}
