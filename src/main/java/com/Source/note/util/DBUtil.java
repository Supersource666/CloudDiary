package com.Source.note.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
    public static Properties properties=new Properties();
    static {
        //加载配置文件
        try{
            InputStream in =DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
            //通过load（）方法将输入流内容加载配置文件对象中
            properties.load(in);
            //通过配置文件对象的getproperty()方法获得驱动名并加载驱动
            Class.forName(properties.getProperty("jdbcName"));
        }catch(Exception e){
            e.printStackTrace();

        }
    }

    /**
     * 得到数据库连接
     * @return
     */
    public static Connection getConnection() {
        Connection connection = null;

        try { //得到数据库连接相关的信息
            String dbUrl = properties.getProperty("dbUrl");
            String dbName = properties.getProperty("dbName");
            String dbPwd = properties.getProperty("dbPwd");
            //得到数据库连接
            connection = DriverManager.getConnection(dbUrl, dbName, dbPwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
        /**
         * 关闭资源
         * @param resultSet
         * @param preparedStatement
         * @param connection
         */
        public static void close(ResultSet resultSet,PreparedStatement preparedStatement,Connection connection)
        {
            try{
                if(resultSet!=null)
            {
                resultSet.close();
            }
                if(preparedStatement!=null)
            {
                preparedStatement.close();
            }
                if(connection!=null)
                {
                    connection.close();
                }

            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }

}
