package com.stx.px.dao2;

import com.stx.px.db.JDBC;

import java.sql.*;
import java.util.Scanner;
public class Mydb2 {
    static Scanner sc = new Scanner(System.in);
    Statement st = null;
    Connection con = null;
    public static void main(String[] args) {
        Mydb2 mydb2 = new Mydb2();
        JDBC jdbc = new JDBC();
        System.out.println("请输入用户名：");
        String name = sc.next();
        System.out.println("请输入密码：");
        String paw = sc.next();
        mydb2.longin(name, paw);
        int cases;
        boolean Bel = true;
        do {
            System.out.println("请输入1:添加用户 2:删除用户  3:删除用户  4:退出");
            cases = sc.nextInt();
            switch (cases) {
                case 1:
                    mydb2.add_user();
                    break;
                case 2:
                    mydb2.del_user();
                    break;
                case 3:
                    mydb2.updata_user();
                    break;
                case 4:
                    Bel = false;
                    break;
                default:
                    System.out.println("输入错误! 重新输入");
                    break;
            }
        } while (Bel);
    }

    public void longin(String name, String pwd) {
        try {
            st = jdbc.opendb();
            ResultSet rs = st.executeQuery("select*from px_stuinfo1 where username='" + name + "' and password='" + pwd + "'");
            while (rs.next()) {
                System.out.println("欢迎光临");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void add_user() {
        System.out.println("==============>添加用户<===========");
        System.out.println("请输入学号:");
        int stuid = sc.nextInt();
        System.out.println("请输入用户名");
        String username = sc.next();
        System.out.println("请输入密码");
        String password = sc.next();
        try {
            st = jdbc.opendb();
            int i = st.executeUpdate("insert into px_stuinfo1(stuid,username,password)values(" + stuid + ",'" + username + "','" + password + " ')");
            if (i > 0) {
                System.out.println("Success");
            } else {
                System.out.println("defeat");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void del_user() {
        System.out.println("请输入您想删除的用户ID");
        int id = sc.nextInt();
        try {

            st = jdbc.opendb();
            int i = st.executeUpdate("delete from px_stuinfo1 where stuid=" + id + "");
            if (i > 0) {
                System.out.println("成功");
            } else {
                System.out.println("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    JDBC jdbc = new JDBC();
    public void updata_user() {
        System.out.println("请输入你要修改的用户ID");
        int id = sc.nextInt();
        System.out.println("请输入新密码");
        String pwd = sc.next();
        try {
            st = jdbc.opendb();
            int i = st.executeUpdate("update px_stuinfo1 set password='" + pwd + "' where stuid=" + id + "");
            if (i > 0) {
                System.out.println("成功");
            } else {
                System.out.println("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
