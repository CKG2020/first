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

    public User findUserByName(String name) {
        return userDao.findByName(name);
    }

    public User findUserByNameAndPassword(String name, String password) {
        return userDao.findByNameAndPassword(name, password);
    }

//    public User login(String username, String password) {
//        return findUserByNameAndPassword(username, password);
//    }

    public boolean register(User user) {
//        User userByName = findUserByName(user.getUername());
//        if (userByName.getUername() != null && userByName.getUername().equals(user.getUername())) {
//            return true;
//        }
//        if (0 == user.getId()) {
//
//            user.setId(UUID.randomUUID());
//        }if (user.getId() == null || user.getId().equals("")) {
//            user.setId(UUID.randomUUID().toString());
//        }
//        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
//        return userDao.insertUser(user) != 0;
//        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
//        return userDao.insertUser(user) != 0;
//    }


        User userByName = findUserByName(user.getName());
        if (userByName.getName() != null && userByName.getName().equals(user.getName())) {
            return true;
        }
        if (user.getId() == null || user.getId().equals("")) {
            user.setId(UUID.randomUUID().toString());
        }
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        return userDao.insertUser(user) != 0;
    }
}
