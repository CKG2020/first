package test2.dao;

import test2.bean.Usr;
import test2.util.DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsrDao {
    private  Connection con;
    private  PreparedStatement ps;
    private  ResultSet rs;
    public boolean  checkUsr(String username, String password)
    {
        Usr u=null;
        String sql="select * from User where username=? and upassword=?";
        try{
            con= DBConn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs=ps.executeQuery();
//         它永远都不会返回null

            if(rs.next())
            {
//                u=new Usr();
////                u.setId(rs.getInt("Id"));
////                u.setUsername(rs.getString("username"));
////                u.setEmail(rs.getString("email"));
////                u.setTel(rs.getString("tel"));
////                u.setSuperuser(rs.getString("superuser"));
//             u.setUid(rs.getString(1));
//             u.setUsername(rs.getString(2));
//             u.setUpassword(rs.getString(3));
//             if(u!=null)
                return true;
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            DBConn.finalize(con, ps, rs);
        }

        return false;
    }
}