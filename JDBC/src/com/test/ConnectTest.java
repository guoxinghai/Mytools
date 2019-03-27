package com.test;

import com.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ConnectTest {

    public static void main(String[] args) throws SQLException {
        //获得连接
        Connection con = JdbcUtil.getConnection();
        //sql语句
        String sql = "select * from student";
        //获得PrepareStatement
        PreparedStatement pst = con.prepareStatement(sql);
        //运行语句并用ResultSet接收
        ResultSet set = pst.executeQuery();
        //打印结果
        System.out.printf("%-10s,%-10s,%-10s,%-2s,%-10s\n","Srollno","Sname","Spassword","Sgender","Sbatch");
        while(set.next()){
            System.out.printf("%-10s,%-10s,%-10s,%-2s,%-10s\n",set.getString(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5));
        }
    }
}
