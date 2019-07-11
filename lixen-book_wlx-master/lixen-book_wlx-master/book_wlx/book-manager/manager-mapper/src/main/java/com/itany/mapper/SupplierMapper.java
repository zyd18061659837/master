package com.itany.mapper;

import com.itany.pojo.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author:wenlixu
 * Date:2019/3/31 14:17
 * Description:
 * Version:1.0
 */
public interface SupplierMapper {

    /**
     * 查询所有的供应商
     * @return
     */
    List<Supplier> selectByFlag(@Param("flag") Integer flag);
}
