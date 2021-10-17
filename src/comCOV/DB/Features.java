package comCOV.DB;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Features {
    static Scanner sc = new Scanner(System.in);
    Statement st = null;
    JDBC jdbc = new JDBC();

    public void longin() {                     //用户登录验证
        System.out.println("请输入用户名：");
        String name = sc.next();
        System.out.println("请输入密码：");
        String pwd = sc.next();
        try {
            st = jdbc.opendb();
            ResultSet rs = st.executeQuery("select*from UserPassage where username='" + name + "' and password='" + pwd + "'");
            while (rs.next()) {
                System.out.println("欢迎光临");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Admlongin() {       //管理员登录验证
        System.out.println("请输入用户名：");
        String name = sc.next();
        System.out.println("请输入密码：");
        String pwd = sc.next();
        try {
            st = jdbc.opendb();
            ResultSet rs = st.executeQuery("select*from Administrator where AD_name='" + name + "' and  AD_password='" + pwd + "'");
            while (rs.next()) {
                System.out.println("欢迎光临");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void UserSelect() {   //用户查询
        System.out.println("请输入你的id");

        try {
            st = jdbc.opendb();
            int id = sc.nextInt();
            ResultSet rs = st.executeQuery("select *from UserPassage where userid=" + id + "");
            while (rs.next()) {
                System.out.print("   姓名:" + rs.getObject("username"));
                System.out.print("   性别:" + rs.getObject("sex"));
                System.out.print("   年龄:" + rs.getObject("age"));
                System.out.println("   电话:" + rs.getObject("tel"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void AdministratorSelect() {   //用户查询
        try {
            st = jdbc.opendb();
            int id = sc.nextInt();
            ResultSet rs = st.executeQuery("select UserPassage.username ,UserPassage.sex, UserPassage.age, UserPassage.tel ,UserCOV_19test.user_test,UserCOV_19test.user_Diagnosis , UserHospital.user_hospital from UserPassage ,UserCOV_19test ,UserHospitalwhere UserPassage.userid=UserCOV_19test.userid and UserCOV_19test.user_testID=UserHospital.user_testID;");
            while (rs.next()) {
                System.out.print("   姓名:" + rs.getObject("username"));
                System.out.print("   性别:" + rs.getObject("sex"));
                System.out.print("   年龄:" + rs.getObject("age"));
                System.out.println("   电话:" + rs.getObject("tel"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add_user() {                //添加用户
        System.out.println("==============>添加用户<===========");
        System.out.println("请输入ID:");
        int stuid = sc.nextInt();
        System.out.println("请输入用户名");
        String username = sc.next();
        System.out.println("请输入密码");
        String password = sc.next();
        try {
            st = jdbc.opendb();
            int i = st.executeUpdate("insert into UserPassage(userid,username,password)values(" + stuid + ",'" + username + "','" + password + " ')");
            if (i > 0) {
                System.out.println("Success");
            } else {
                System.out.println("defeat");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void del_user() {             //删除用户
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

    public void updata_user() {         //修改用户
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
