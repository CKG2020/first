package com.ease.architecture.dao1.mapper;

import com.ease.architecture.entity1.Member;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberMapper {
    @Select("SELECT * FROM  member   }")
    Member findAllMember();

    @Select("SELECT * FROM  member   WHERE   id=#{id,jdbcType=INTEGER")
      List  <Member> findById(@Param("id") int id );


    @Delete("DELETE FROM member WHERE phone=#{phone,jdbcType=VARCHAR}")
    int  deleteMember(@Param("phone") String phone);


    @Update("UPDATE  member  set  adress=#{adress,jdbcType=VARCHAR} where phone=#{phone,jdbcType=VARCHAR}")
    int updateAdress(@Param("adress") String adress,@Param("phone") String phone);



    @Update("UPDATE  member  set  discountlevel=#{discountlevel,jdbcType=DOUBLE} where phone=#{phone,jdbcType=VARCHAR}")
    int updateDiscountlevel(@Param("discountlevel") String discountlevel,@Param("phone") String phone);

}


