package com.ease.architecture.dao1.mapper;

import com.ease.architecture.entity1.Casher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface CasherMapper {

    @Select("SELECT * FROM casher  WHERE name=#{name,jdbcType=VARCHAR} AND password=#{password,jdbcType=VARCHAR}")
    public Casher findByNumAndPassword(@Param("name") String stu_number, @Param("password") String stu_password);
}
