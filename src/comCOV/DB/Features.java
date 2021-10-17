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
            ResultSet rs = st.executeQuery("select * from UserPassage where userid="+id+"");
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
    @Test
    public void AdministratorSelect() {   //用户查询
        try {
            st = jdbc.opendb();
            ResultSet rs = st.executeQuery("select UserPassage.username ,UserPassage.sex, UserPassage.age, UserPassage.tel ,UserCOV_19test.user_test,\n" +
                    "UserCOV_19test.user_Diagnosis , UserHospital.user_hospital ,UserCOV_19test.user_testID\n" +
                    "from UserPassage ,UserCOV_19test ,UserHospital\n" +
                    "where UserPassage.userid=UserCOV_19test.userid and UserCOV_19test.user_testID=UserHospital.user_testID");
            while (rs.next()) {
                System.out.print("姓名:" + rs.getObject("username")+"  ||   性别:" + rs.getObject("sex"));
//                System.out.print("  ||   性别:" + rs.getObject("sex"));
                System.out.print("  ||   年龄:" + rs.getObject("age"));
                System.out.print("  ||   电话:" + rs.getObject("tel"));
                System.out.print("  ||  测试方法:"+rs.getObject("user_test"));
                System.out.print("  ||  确诊状态:"+rs.getObject("user_Diagnosis"));
                System.out.print("  ||  在院状态:"+rs.getObject("user_hospital"));
                System.out.println("  ||  检查ID:"+rs.getObject("user_testID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        @Test
    public void add_user() {                //添加用户
        System.out.println("==============>添加用户<===========");
        System.out.println("请输入ID:");
        int stuid = sc.nextInt();
        System.out.println("请输入用户名");
        String username = sc.next();
        System.out.println("请输入密码");
        String password = sc.next();
        System.out.println("请输入性别");
        String sex= sc.next();
        System.out.println("请输入年龄");
        int age= sc.nextInt();
        System.out.println("请输入电话");
        String tel= sc.next();
        try {
            st = jdbc.opendb();
            int i = st.executeUpdate("insert into UserPassage(userid,username,password,sex,age,tel)values(" + stuid + ",'" + username + "','" + password + " ','"+sex+"',"+age+",'"+tel+"')");
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
            int i = st.executeUpdate("delete from UserPassage where stuid=" + id + "");
            if (i > 0) {
                System.out.println("成功");
            } else {
                System.out.println("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void updata_user() {         //修改用户
        System.out.println("请输入你要修改的用户测试ID：");
        int id = sc.nextInt();
        System.out.println("修改确诊类型:");
        String test = sc.next();
        try {
            st = jdbc.opendb();
            int i = st.executeUpdate("update UserCOV_19test set  user_Diagnosis='" + test + "' where user_testID=" + id + "");
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
