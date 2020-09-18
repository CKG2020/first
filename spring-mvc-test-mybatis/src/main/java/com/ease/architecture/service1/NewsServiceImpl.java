package com.ease.architecture.service1;

import com.ease.architecture.dao1.mapper.NewsMapper;
import com.ease.architecture.entity1.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl {

    @Autowired
    private NewsMapper  newsMapper;


    public List<News>  findAllNews(){
     return  newsMapper.findAllNews();

    }

}
