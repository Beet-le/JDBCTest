package JDBCEncape.DAO;




import JDBCEncape.DB.UserModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class db {
    public static void main(String[] args) {
        db db = new db();
        ArrayList list = db.login();
        for (int i = 0; i < list.size(); i++) {
            UserModel user = (UserModel) list.get(i);
            System.out.println(user.getStuid());
            System.out.println(user.getUsername());
            System.out.println(user.getTel());
        }
    }
    public ArrayList login() {
        ArrayList list = new ArrayList();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");         //加载驱动
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:BEETLE", "system", "Xxq123456");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select*from px_stuinfo1 ");
            while (rs.next()) {
                UserModel user = new UserModel();
                user.setStuid(rs.getInt("stuid"));
                user.setUsername(rs.getString("username"));
                user.setTel(rs.getString("tel"));
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

