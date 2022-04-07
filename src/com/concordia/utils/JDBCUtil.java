package com.concordia.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @Author Wei Qi
 * @Description JDBC Util Class
 * Date: 2022-02-20  15:15
 */
public class JDBCUtil {
    private static DataSource dataSource;
    static {
        try {
            //1. Use the class loader to read the configuration file and convert it to a byte input stream
            //testing connection
            InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");

           //production connection
           // InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("druid_production.properties");
            //2. Load byte input stream using Properties object
            Properties properties = new Properties();
            properties.load(is);
            //3. Use DruidDataSourceFactory to create connection pool objects
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author Wei Qi
     * @Description Get connection pool object
     * @Date 2/20/2022 1:45 AM
     * @Param []
     * @return javax.sql.DataSource
     */
    public static DataSource getDataSource(){

        return dataSource;
    }

    /**
     * @Author Wei Qi
     * @Description Get DB connection
     * @Date 2/20/2022 1:45 AM
     * @Param []
     * @return java.sql.Connection
     */
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * @Author Wei Qi
     * @Description Close DB connection
     * @Date 2/20/2022 1:45 AM
     * @Param [connection]
     * @return void
     */
    public static void releaseConnection(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
