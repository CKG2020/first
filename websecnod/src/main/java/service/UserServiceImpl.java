package service;
import dao.UserDao;
import entity.User;

import java.sql.SQLException;
import java.util.UUID;

public class UserServiceImpl {

    private UserDao userDao = new UserDao();

    public User findById(String id) {

        return userDao.findById(id);
    }




    public User findByName( String username) throws SQLException {
        return userDao.findByName(username);
    }






    public User findByNameAndPassword(String username, String password) throws SQLException {
        return userDao.findByNameAndPassword(username, password);
    }



    public User login(String username, String password) throws SQLException {
        return findByNameAndPassword(username, password);
    }



    public boolean register(User user) throws SQLException {
        if (findByName(user.getUsername()) != null) {
            return true;
        }
//        if (user.getId() == null || user.getId().equals("")) {
//            user.setId(UUID.randomUUID().toString());
//        }
        return userDao.register(user) != 0;
    }
}
