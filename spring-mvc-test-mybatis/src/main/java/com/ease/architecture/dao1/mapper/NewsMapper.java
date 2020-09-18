package com.ease.architecture.dao1.mapper;

import com.ease.architecture.entity1.News;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsMapper {


    @Select("SELECT * FROM news ")
     List<News> findAllNews();
}
