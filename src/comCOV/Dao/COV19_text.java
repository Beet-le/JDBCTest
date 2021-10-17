package comCOV.Dao;

import comCOV.DB.Features;

import java.util.Scanner;

public class COV19_text {
    static Scanner sc =new Scanner(System.in);
   static Features features=new Features();
    public static void main(String[] args) {

        COV19_text cov19_text=new COV19_text();
        System.out.println("欢迎使用核酸查询系统");
        int print1;
        boolean Bel = true;
        do {
            System.out.println("1:用户登录  2:用户注册  3:管理员登录  4:退出");
            print1 = sc.nextInt();
            switch (print1) {
                case 1:
                    cov19_text.userselect();
                    break;
                case 2:
                    features.add_user();
                    features.longin();
                    cov19_text.userselect();
                    break;
                case 3:
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
    public  void userselect(){
        features.longin();
        System.out.print("你的信息:");
        features.UserSelect();
        System.out.println("查询完毕");
    }
    public void Adminster(){  //管理员设置
        System.out.println();
        features.Admlongin();
    }

}
