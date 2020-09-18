package com.ease.architecture.dao1.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface  GoodsMapper {

    @Select("SELECT  price FROM  goods   WHERE   productID=#{id,jdbcType=INTEGER }")
    int findPrice(@Param("productID") int productID);

    @Select("SELECT  amount  FROM  storage   WHERE   productID=#{id,jdbcType=INTEGER}   ")
    int findQuantity(@Param("productID") int productID );

    @Select("SELECT   SUM(quantity)  FROM  sales   WHERE   productID=#{id,jdbcType=INTEGER}")
    int findMoney(@Param("productID") int productID);

}
