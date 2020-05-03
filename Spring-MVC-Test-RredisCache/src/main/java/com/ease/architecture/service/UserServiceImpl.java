package com.ease.architecture.service;

import com.ease.architecture.dao.UserDao;
import com.ease.architecture.entity.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl {

    @Autowired
    private UserDao userDao;
//
//    public User findUserById(String   id) {
//        return userDao.findByUserId(id);
//    }

    public User findUserByName(String username) {
        return userDao.findByName(username);
    }

//    public User findUserByNameAndPassword(String name, String password) {
//        return userDao.findByNameAndPassword(name, password);
//    }

    //    public User login(String username, String password) {
//        return findUserByNameAndPassword(username, password);
//    }
//不合理之处::::::每条数据不可以重名
    public boolean register(String username, String password) {
        final User user = new User();
        User userByName = findUserByName(username);
        if (userByName != null ) {
            return true;
        }
        else {
            user.setId(UUID.randomUUID().toString());
            user.setName(username);
            user.setPassword(DigestUtils.md5Hex(password));
            return userDao.insertUser(user) != 0;
        }
    }

    public User findByNameAndPassword(String username, String password) {
        return userDao.findByNameAndPassword(username, password);
    }
}
