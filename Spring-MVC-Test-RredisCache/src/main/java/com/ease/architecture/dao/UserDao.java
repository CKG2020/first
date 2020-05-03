package com.ease.architecture.dao;

import com.ease.architecture.entity.User;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {
    @Autowired
    RedisCommands<String, String> redisCommands;

    @Autowired
    private JdbcTemplate jdbcTemplate;


//    @Autowired
//    private RedisTemplate redisTemplate;
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
//            if(redisCommands.exists(name)>0) {
//        System.out.println("redis");
//        String res = redisCommands.get(name);
//        if(res!=null && res.equals(student.getSpwd())){
//            return student;
//        }else{
//            student.setSpwd("");
//            System.out.println("密码错误");
//            return student;
//        }
    public User findByName(String username) {
        final User user = new User();
        if (redisCommands.exists(username) > 0) {
            System.out.println("redis");

            user.setName(username);
            user.setPassword(redisCommands.get(username));

                return user;
            }
            else {
            String sql = "SELECT * FROM   User WHERE name=?";
            jdbcTemplate.query(sql, new Object[]{username}, new RowCallbackHandler() {
                @Override
                public void processRow(ResultSet resultSet) throws SQLException {
//                    user.setId(resultSet.getString(1));
                    user.setName(resultSet.getString(2));
                    user.setPassword(resultSet.getString(3));
                    redisCommands.set(user.getName(), user.getPassword());
                }
            });
            System.out.println("xxxxxxxx");
            System.out.println(user.getName());
                return user;

        }

    }


    public User findByNameAndPassword(String username, String password) {

        final User user = new User();
        if (redisCommands.exists(username) > 0)
        {
            System.out.println("redis");
            String res = redisCommands.get(username);
            if (res != null && res.equals(password)) {
                System.out.println("xxxxxxxxxxxxxxxx");
                user.setName(username);
                user.setPassword(res);
                return user;}
//            } else {
//                user.setPassword("");
//                System.out.println("密码错误或用户名不正确");
//                return null;
//            }
        }
        else
            {
                System.out.println("=============================redis没有查询到东西");

                String sql = "SELECT * FROM User WHERE name=? AND password=?";
                jdbcTemplate.query(sql, new Object[]{username, password}, new RowCallbackHandler() {
                    @Override
                    public void processRow(ResultSet resultSet) throws SQLException {
                        redisCommands.set(username, password);
                        user.setName(resultSet.getString(2));
                        user.setPassword(resultSet.getString(3));

                        System.out.println(user.getName());

                    }
                });


                }
        return user;
//不足之处要是查询数据库没有的用户的姓名并不能给出提示
        }


    public int insertUser(User user) {
        String sql = "INSERT INTO User (id,name,password) VALUES (?,?,?)";
        int a = jdbcTemplate.update(sql, user.getId(), user.getName(), user.getPassword());
//
//        if (redisTemplate.hasKey(user.getId())) {//更新DB数据完成后，若redis中存在，则删除数据
//            redisTemplate.opsForHash().delete("user", user.getId());
//        }
//        return a;
        if (redisCommands.exists(user.getName())<0){

            redisCommands.set(user.getName(),user.getPassword());
        }
        return a;
    }
}


//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    private StatefulRedisConnection<String, String> connection;
//
//
//    public User findByUserId(String id) {
//        final User user = new User();
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
//    public User findByName(String name) {
//
//
//        final User user = new User();
//
//        String id = connection.sync().get(name);
//        if(id!=null&&!id.equals("")){
//            user.setId(id);
//            user.setName(name);
//        }
//        else {
//            String sql = "SELECT * FROM User WHERE name=?";
//            jdbcTemplate.query(sql, new Object[]{name}, new RowCallbackHandler() {
//                @Override
//                public void processRow(ResultSet resultSet) throws SQLException {
//                    String id = resultSet.getString(1);
//                    connection.sync().set(name,id);
//                    connection.sync().set(id,resultSet.getString(3));
//
//                }
//            });
//            id = connection.sync().get(name);
//            if(id==null||id.equals("")){
//                return null;
//            }
//            user.setId(id);
//            user.setName(name);
//        }
//
//        return user;
//    }
//
//    public User findByNameAndPassword(String name, String password) {
//
//        final User user = new User();
////        String sql = "SELECT * FROM t_user_1 WHERE name=? AND password=?";
////        jdbcTemplate.query(sql, new Object[]{name, password}, new RowCallbackHandler() {
////            @Override
////            public void processRow(ResultSet resultSet) throws SQLException {
////                user.setId(resultSet.getString(1));
////                user.setName(resultSet.getString(2));
////            }
////        });
//        String id = connection.sync().get(name);
//        if(id!=null&&!id.equals("")){
//            if(!connection.sync().get(id).equals(password)){
//                return user;
//            }
//            user.setId(id);
//            user.setName(name);
//        }else {
//            String sql = "SELECT * FROM User WHERE name=? AND password=?";
//            jdbcTemplate.query(sql, new Object[]{name, password}, new RowCallbackHandler() {
//                @Override
//                public void processRow(ResultSet resultSet) throws SQLException {
//                    String id = resultSet.getString(1);
//                    connection.sync().set(name,id);
//                    connection.sync().set(id,resultSet.getString(3));
//
//                }
//            });
//            id = connection.sync().get(name);
//            if(id==null||id.equals("")){
//                return null;
//            }
//            user.setId(connection.sync().get(name));
//            user.setName(name);
//        }
//
//        return user;
//    }
//
//    public int insertUser(User user) {
//        String sql = "INSERT INTO User (id,name,password) VALUES (?,?,?)";
//        return jdbcTemplate.update(sql, user.getId(), user.getName(), user.getPassword());
//    }
//}
