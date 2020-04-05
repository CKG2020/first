package com.example.hikaricp.demo;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公共工具Component
 *
 */
//@Component
//public class CommonComponent {
//
//    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * key位填类型,value位填传参的值
     *
     * @param sql
//     * @param param
     * @return
     */
    // 获取JDBC的数据,并返回list数据,每条信息放在Map中
//    public List<Map<String, Object>> getJdbcData(String sql, Object[] param) {
//            public  void getJdbcData(String sql){
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//        try {
//            conn = HikariPoolManager.getConnection();
//            pstmt = conn.prepareStatement(sql);
////            if (param != null) {
////                if (param.length > 0) {
////                    for (int i = 0; i < param.length; i++) {
////                        pstmt.setObject(i + 1, param[i]);
////                    }
////                }
////            }
//            ResultSet rs = pstmt.executeQuery();
////            // 获取列信息
//          ResultSetMetaData columns = rs.getMetaData();
////            // 列数量
//            int columnNum = columns.getColumnCount();
//            while (rs.next()) {
////                Map<String, Object> resultMap = new HashMap<String, Object>();
//                // 将结果返回成Map，key为列表名，value为该字段的值
//                for (int j = 1; j <= columnNum; j++) {
//                    System.out.print("\t" + rs.getString(j));
//                }
////                list.add(resultMap);
//            }
//
//            for (int i=0;i<list.size();i++){
//                System.out.println(list.get(i));
//            }
//        }
//
////方法1
////                for(int i = 0;i < list.size();i++){
////               System.out.println(list.get(i));
////                }
////方法2
////                Iterator it = list.iterater();
////                while(it.hasNext()){
////               System.out.println(it.next());
////                }
//
//
//
//
//        catch (Exception e) {
//            logger.error("sql: " + sql);
//            logger.error("Exception: " + e.getMessage(), e);
////            return list;
//        } finally {
//            try {
//                if (conn != null) {
//                    conn.close();
////                    conn = null;
//                }
//                if (pstmt != null) {
//                    pstmt.close();
//
//                }
//
//            } catch (SQLException e) {
//                logger.error("sql: " + sql);
//                logger.error("SQLException: " + e.getMessage(), e);
//            }
//        }
//            }
//
//}