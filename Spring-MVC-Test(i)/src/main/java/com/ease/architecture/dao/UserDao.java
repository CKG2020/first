package com.ease.architecture.dao;

import com.ease.architecture.entity.User;
import io.lettuce.core.api.StatefulRedisConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {


//    @Autowired
//    private JdbcTemplate jdbcTemplate;
// @Autowired
// private  RedisTemplate redisTemplate;
//
//    public User findByUserId(String id) {
//        final User user = new User();
//
////        if(redisTemplate.hasKey(id))
//        String sql = "SELECT * FROM User WHERE id=?";
//        jdbcTemplate.query(sql, new Object[]{id}, new RowCallbackHandler() {
//            @Override
//            public void processRow(ResultSet resultSet) throws SQLException {
//                user.setId(resultSet.getString(1));
//                user.setName(resultSet.getString(2));
//            }
//        });
//        return user;
//    }
//
//
//
//    public User findByName(String name) {
//        final User user = new User();
//        if (redisTemplate.hasKey(name)) {
//
//            return (User) redisTemplate.opsForHash().get("user", name);
//        } else {
//            String sql = "SELECT * FROM   User WHERE name=?";
//            jdbcTemplate.query(sql, new Object[]{name}, new RowCallbackHandler() {
//                @Override
//                public void processRow(ResultSet resultSet) throws SQLException {
//                    user.setId(resultSet.getString(1));
//                    user.setName(resultSet.getString(2));
//                }
//            });
//            return user;
//        }
//
//    }
//
//
//
//    public User findByNameAndPassword(String name, String password) {
//        if (redisTemplate.hasKey(name)) {
//
//            return (User) redisTemplate.opsForHash().get("user", name);
//        } else {
//            final User user = new User();
//            String sql = "SELECT * FROM User WHERE name=? AND password=?";
//            jdbcTemplate.query(sql, new Object[]{name, password}, new RowCallbackHandler() {
//                @Override
//                public void processRow(ResultSet resultSet) throws SQLException {
//                    user.setId(resultSet.getString(1));
//                    user.setName(resultSet.getString(2));
//                }
//            });
//            return user;
//        }
//
//    }
//    public int insertUser(User user) {
//        String sql = "INSERT INTO User (id,name,password) VALUES (?,?,?)";
//        int a=jdbcTemplate.update(sql, user.getId(), user.getName(), user.getPassword());
//
//        if(redisTemplate.hasKey(user.getId())){//更新DB数据完成后，若redis中存在，则删除数据
//            redisTemplate.opsForHash().delete("user",user.getId());
//        }
//        return a;
//    }


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private StatefulRedisConnection<String, String> connection;


    public User findByUserId(String id) {
        final User user = new User();
        String sql = "SELECT * FROM User WHERE id=?";
        jdbcTemplate.query(sql, new Object[]{id}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setId(resultSet.getString(1));
                user.setName(resultSet.getString(2));
            }
        });
        return user;
    }


    public User findByName(String name) {


        final User user = new User();

        String id = connection.sync().get(name);
        if(id!=null&&!id.equals("")){
            user.setId(id);
            user.setName(name);
        }
        else {
            String sql = "SELECT * FROM User WHERE name=?";
            jdbcTemplate.query(sql, new Object[]{name}, new RowCallbackHandler() {
                @Override
                public void processRow(ResultSet resultSet) throws SQLException {
                    String id = resultSet.getString(1);
                    connection.sync().set(name,id);
                    connection.sync().set(id,resultSet.getString(3));

                }
            });
            id = connection.sync().get(name);
            if(id==null||id.equals("")){
                return null;
            }
            user.setId(id);
            user.setName(name);
        }

        return user;
    }

    public User findByNameAndPassword(String name, String password) {

        final User user = new User();
//        String sql = "SELECT * FROM t_user_1 WHERE name=? AND password=?";
//        jdbcTemplate.query(sql, new Object[]{name, password}, new RowCallbackHandler() {
//            @Override
//            public void processRow(ResultSet resultSet) throws SQLException {
//                user.setId(resultSet.getString(1));
//                user.setName(resultSet.getString(2));
//            }
//        });
        String id = connection.sync().get(name);
        if(id!=null&&!id.equals("")){
            if(!connection.sync().get(id).equals(password)){
                return user;
            }
            user.setId(id);
            user.setName(name);
        }else {
            String sql = "SELECT * FROM User WHERE name=? AND password=?";
            jdbcTemplate.query(sql, new Object[]{name, password}, new RowCallbackHandler() {
                @Override
                public void processRow(ResultSet resultSet) throws SQLException {
                    String id = resultSet.getString(1);
                    connection.sync().set(name,id);
                    connection.sync().set(id,resultSet.getString(3));

                }
            });
            id = connection.sync().get(name);
            if(id==null||id.equals("")){
                return null;
            }
            user.setId(connection.sync().get(name));
            user.setName(name);
        }

        return user;
    }

    public int insertUser(User user) {
        String sql = "INSERT INTO User (id,name,password) VALUES (?,?,?)";
        return jdbcTemplate.update(sql, user.getId(), user.getName(), user.getPassword());
    }
}
