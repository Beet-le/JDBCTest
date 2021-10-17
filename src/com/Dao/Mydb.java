package com.Dao;

import org.junit.Test;

import java.sql.*;
import java.util.Collection;

public class Mydb {
    @Test
    public void  opendb() throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver");         //加载驱动
        String url = "jdbc:oracle:thin:@localhost:1521:BEETLE";
        String user = "system";
        String password = "Xxq123456";
        Connection con = DriverManager.getConnection(url, user, password);  //连接数据库
        Statement statement= con.createStatement();//操作数据库

        ResultSet resultSet = statement.executeQuery("");

        if(resultSet.next()){
            System.out.println("hygl");
        }else {
            System.out.println("输入有误");
        }
    }
}
