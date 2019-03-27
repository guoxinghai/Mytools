package com.util;

import java.sql.*;
import java.util.ResourceBundle;

public class JdbcUtil {

    //获得数据库连接
    public static Connection getConnection(){
        Connection con = null;
        //用于读取连接数据库需要的信息
        ResourceBundle re = ResourceBundle.getBundle("db");
        //获得信息
        String driver = re.getString("driver");
        String url = re.getString("url");
        String user = re.getString("user");
        String pass = re.getString("password");
        //注册驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //获得连接
        try {
            con = DriverManager.getConnection(url,user,pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //返回连接
        return con;
    }

    //关闭资源
    public static void release(Connection con, PreparedStatement pst, ResultSet set){
        try {
            if(con != null) {
                con.close();
            }
            if(pst != null){
                pst.close();
            }
            if(set != null){
                set.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
