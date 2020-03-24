package com.wspring1.demo.dao;


import com.wspring1.demo.model.Apply;
import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ApplyDao {
    Apply findByapid(int apid);
}
