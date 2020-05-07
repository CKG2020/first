package test2.dao;

import test2.bean.Usr;
import test2.util.DBConn;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        UsrDao usrDao = new UsrDao();
      Boolean a=usrDao.checkUsr("xxx","12345678");
//        System.out.println(usrDao.checkUsr("xxx", "123456"));

        System.out.println(a);
//        System.out.println(user.getUsername());


//        String sql="select * from User ";
//
//         Connection con= DBConn.getConnection();
//
//       PreparedStatement ps=con.prepareStatement(sql);
//
//     ResultSet set= ps.executeQuery(sql);
//        while (set.next()){
//            System.out.println(set.getString(2));
//        }
    }
}
