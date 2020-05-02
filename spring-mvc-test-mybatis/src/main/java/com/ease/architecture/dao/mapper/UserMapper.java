package com.ease.architecture.dao.mapper;

import com.ease.architecture.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("SELECT * FROM User  WHERE name=#{name,jdbcType=VARCHAR}")
    public User findByName(@Param("name") String name);

    @Select("SELECT * FROM User  WHERE name=#{name,jdbcType=VARCHAR} AND password=#{password,jdbcType=VARCHAR}")
    public User findByNameAndPassword(@Param("name") String name, @Param("password") String password);

    @Insert("INSERT INTO User  (id,name,password) VALUES (#{id},#{name},#{password})")
    public int insertUser(User user);
}
