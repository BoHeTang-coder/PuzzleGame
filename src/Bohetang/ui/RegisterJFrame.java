package Bohetang.ui;

import javax.swing.*;

public class RegisterJFrame extends JFrame {
    //RegisterJFrame表示游戏的注册界面，跟注册界面相关的代码都写在这个类中
    public RegisterJFrame(){
        //在创建对象的同时，完成界面的初始化工作
        //1.设置界面的宽高
        this.setSize(488,500);//设置注册界面窗口的宽高
        this.setVisible(true);//设置注册界面窗口可见
        //2.设置界面标题
        this.setTitle("拼图游戏注册界面");
        //3.设置界面置顶
        this.setAlwaysOnTop(true);//设置注册界面窗口置顶
        //4.设置界面居中
        this.setLocationRelativeTo(null);//设置注册界面窗口居中
        //5.设置关闭模式
        this.setDefaultCloseOperation(3);//设置注册界面窗口关闭模式
    }
}
