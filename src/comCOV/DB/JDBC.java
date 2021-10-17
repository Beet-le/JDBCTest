package comCOV.DB;

import  java.sql.*;
public class JDBC {
    Statement st=null;
    Connection con=null;
    public Statement opendb(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");         //加载驱动
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:BEETLE", "system","Xxq123456");
            st=con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }
    public Connection close_db(){
        try {
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}