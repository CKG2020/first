package com.ease.architecture.service1;

import com.ease.architecture.dao1.mapper.CasherMapper;
import com.ease.architecture.entity1.Casher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CasherServiceImpl {
    @Autowired
    private CasherMapper  casherMapper;

    public Casher findUserByNameAndPassword(String username, String password) {
        return casherMapper.findByNumAndPassword(username, password);
    }


}
