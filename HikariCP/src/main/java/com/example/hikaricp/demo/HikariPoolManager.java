package com.example.hikaricp.demo;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class HikariPoolManager {


    private static Logger logger = LoggerFactory.getLogger(HikariPoolManager.class);

//    private static final String DB_CONFIG_FILE = "dbconfig.properties";

    // 数据库服务器addr
    private static String db_url = null;
    // 数据库登录用户名
    private static String db_username = null;
    // 数据库登录密码
    private static String db_password = null;
    // 数据库驱动
    private static String driverClassName = null;
    // 数据库连接数
    private static short db_max_conn = 0;
    // 数据库连接端口
    private static short db_port = 0;
    // 数据库名称
    private static String db_name = null;

    private static HikariDataSource dataSource;
    private static HikariPoolManager hikariPoolManager;

    /**
     * 单例模式
     *
     * @return
     */
    public static HikariPoolManager getInstance() {
        if (hikariPoolManager == null)
            hikariPoolManager = new HikariPoolManager();
        return hikariPoolManager;
    }

    /**
     * 启动
     *
     * @throws IOException
     * @throws SQLException
     */
    public static void start() throws IOException, SQLException {
        logger.info("连接池初始化Start!!!");
//        Properties properties = new Properties();
//        InputStream in = HikariPoolManager.class.getClass().getResourceAsStream("dbconfig.properties");
//        properties.load(in);
//
//        db_url = String.valueOf(properties.getProperty("spring.mysql.devcenter.datasource.url"));
//        db_username = String.valueOf(properties.getProperty("spring.mysql.devcenter.datasource.username"));
//        db_password = String.valueOf(properties.getProperty("spring.mysql.devcenter.datasource.password"));
//        driverClassName = String.valueOf(properties.getProperty("spring.mysql.devcenter.datasource.driverClassName"));
//
//        if (db_url == null || db_url.length() == 0) {
//            logger.error("配置的数据库ip地址错误!");
//            System.exit(0);
//        }

//        HikariConfig config = new HikariConfig();
//        config.setJdbcUrl(db_url);
//        config.setUsername(db_username);
//        config.setPassword(db_password);
//        config.setDriverClassName(driverClassName);
//        config.addDataSourceProperty("cachePrepStmts", "true");
//        config.addDataSourceProperty("prepStmtCacheSize", "250");
//        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
//        // 设置连接超时为8小时
//        config.setConnectionTimeout(8 * 60 * 60);
//        dataSource = new HikariDataSource(config);


        HikariConfig hikariConfig1 = new HikariConfig();
        hikariConfig1.setJdbcUrl("jdbc:mysql://localhost:3306/db1");//oracle
        hikariConfig1.setDriverClassName("com.mysql.jdbc.Driver");
        hikariConfig1.setUsername("root");
        hikariConfig1.setPassword("root");
        hikariConfig1.addDataSourceProperty("cachePrepStmts", "true");
        hikariConfig1.addDataSourceProperty("prepStmtCacheSize", "250");
        hikariConfig1.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        HikariDataSource dataSource = new HikariDataSource(hikariConfig1);

        logger.info("连接池初始化End!!!");
        Connection connection=dataSource.getConnection();
        Statement stmt=connection.createStatement();
        ResultSet resultSet=stmt.executeQuery("select  * from User");
        int numcols = resultSet.getMetaData().getColumnCount();
        while(resultSet.next()){
            for(int i=1;i<=numcols;i++) {
                System.out.print("\t" + resultSet.getString(i));
            }

        }
//        stmt.close();
//        connection.close();
//        dataSource.close();

    }

    /**
     * 打开连接
     *
     * @return
     * @throws SQLException
     */
    public synchronized static Connection getConnection() throws SQLException {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            logger.error("error:" + e.getMessage());
            dataSource.close();
            return null;
        }
    }

    /**
     * 关闭连接
     *
     * @return
     * @throws SQLException
     */
    public static  boolean stop() throws SQLException {
        dataSource.close();
        return true;
    }
}
