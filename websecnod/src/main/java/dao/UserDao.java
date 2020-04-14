package dao;

import entity.User;
import utils.MysqlConnectionUtil;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public User findById(String id) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        User user = null;
        try {
            conn = MysqlConnectionUtil.getInstance().getConnection();
            preparedStatement = conn.prepareStatement("SELECT  * FROM student3 where id=?");
            preparedStatement.setString(1, String.valueOf(1));
            set = preparedStatement.executeQuery();
            if (set != null && set.next()) {

                user = new User();
                user.setId(1);
                user.setPassword(set.getString(3));
                user.setUsername(set.getString(2));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MysqlConnectionUtil.realease(conn, preparedStatement, set);
        }
        return user;
    }

    public User findByName (String name) throws SQLException {
        User user=null;
        Connection conn=null;
        PreparedStatement pre=null;
        ResultSet set=null;

        conn=MysqlConnectionUtil.getConnection();
        pre=conn.prepareStatement("select * from student3 where Username =?");
        pre.setString(1,"ckg");
        set=pre.executeQuery();
        if(set!=null&& set.next()){
            user=new User();
            user.setId(set.getInt(1));
            user.setPassword(set.getString(3));
            return user;
        }

    MysqlConnectionUtil.realease(conn,pre,set);


        return user;
    }

public User findByNameAndPassword(String name,String password) throws SQLException {
        User user=null;
        Connection conn=null;
        PreparedStatement pre=null;
        ResultSet  result=null;

        conn=MysqlConnectionUtil.getConnection();
        pre=conn.prepareStatement("select * from student3 where Username=? and Password=?");
        pre.setString(1,"name");
        pre.setString(2,"password");
        result=pre.executeQuery();
        if (result!=null&&result.next()){
            user=new User();
            user.setPassword(result.getString(3));
            user.setUsername(result.getString(2));
            user.setId(result.getInt(1));
            return user;
        }

    MysqlConnectionUtil.realease(conn,pre,result);
    return user;
}



public  int  register (User user) throws SQLException {

        Connection conn=null;
        PreparedStatement pre =null;



        conn=MysqlConnectionUtil.getConnection();
        pre=conn.prepareStatement("insert  into  student3 values(?,?,?)");
        pre.setInt(1,user.getId());
        pre.setString(2,user.getUsername());
        pre.setString(3,user.getPassword());
        int a=pre.executeUpdate();
        ResultSet set=null;
        MysqlConnectionUtil.realease(conn,pre,set );
        return a;
}




}