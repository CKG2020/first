package Date;

import java.sql.*;

public class JDBCTest {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://47.94.21.104/db3";

    //数据库名和密码自己修改
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 2.
            Class.forName(JDBC_DRIVER);
            //3.
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            //4.
            stmt = conn.createStatement();
            String sql;
//            a)English:45 	Math:89	Computer:100
//            sql = "insert  into Student values ('scofield','45','89','100')";
            sql="select * from Student where Name='scofield'";

            stmt.execute(sql);



            ResultSet rs = stmt.executeQuery(sql);
            //5.
            while(rs.next()){
                String Name = rs.getString("Name");
                String English = rs.getString("English");
                String Math = rs.getString("Math");
                String Computer = rs.getString("Computer");

                System.out.print("Name: " + Name);
                System.out.print(",  English: " +  English);
                System.out.print(", Math: " + Math);
                System.out.println(", Computer: " + Computer);
            }
            //6.
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){

            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();// 同上
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){

            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}

