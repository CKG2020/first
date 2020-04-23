package ch3;

import test2.util.DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsrDao {
    private Connection conn;
    private PreparedStatement stat;
    private ResultSet set;

    public List<User> findAllUser() {
        List<User> list = new ArrayList<User>();
        User u = null;
        String sql = "select * from User";
        try {
            conn = DBConn.getConnection();
            stat = conn.prepareStatement(sql);
            set = stat.executeQuery();
            while (set.next()) {
                u = new User();
                u.setId(set.getInt(1));
                u.setUpassword(set.getString(3));
                u.setUsername(set.getString(2));
                list.add(u);

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.finalize(conn, stat, set);
        }
        return list;
    }
}