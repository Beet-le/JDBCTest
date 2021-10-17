package com.Bt;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class jdbc01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver"); //加载驱动
        String url="jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=false";
        String username="root";
        String password="123456";
        Connection connection = DriverManager.getConnection(url,username,password); //链接
        Statement statement = connection.createStatement();
        String sql ="SELECT * FROM information";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("id:"+resultSet.getObject("id"));
            System.out.println("username"+resultSet.getObject("username"));
            System.out.println("pasword"+resultSet.getObject("pasword"));
            System.out.println("sex"+resultSet.getObject("sex"));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
