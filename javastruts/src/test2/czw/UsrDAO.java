package test2.czw;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsrDAO {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    public Usr checkUsr(String username, String password)
    {
        Usr u=null;
        String sql="select * from User where username=? and upassword=?";
        try{
            con=DBConn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs=ps.executeQuery();
            if(rs.next())
            {
                u=new Usr();
                u.setId(rs.getInt("uid"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("upassword"));
//                u.setEmail(rs.getString("email"));
//                u.setTel(rs.getString("tel"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBConn.finalize(con, ps, rs);
        }
        return u;
    }

    public Usr checkAdmin(String username, String password)
    {/*
     *0232陈志威
     */
        Usr u=null;
        String sql="select * from user where name=? and password=?";
        try{
            con=DBConn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs=ps.executeQuery();
            if(rs.next())
            {
                u=new Usr();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("name"));
                u.setPassword(rs.getString("password"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBConn.finalize(con, ps, rs);
        }
        return u;
    }
}
