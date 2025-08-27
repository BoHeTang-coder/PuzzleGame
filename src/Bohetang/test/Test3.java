package Bohetang.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test3 {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        //1.设置界面的宽高
        jf.setSize(488,430);//设置登录界面窗口的宽高
        //2.设置界面标题
        jf.setTitle("事件测试");
        //3.设置界面置顶
        jf.setAlwaysOnTop(true);//设置登录界面窗口置顶
        //4.设置界面居中
        jf.setLocationRelativeTo(null);//设置登录界面窗口居中/
        //5.设置关闭模式
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置登录界面窗口关闭模式
        //6.取消默认的居中放置,这样才能按照XY轴的坐标进行放置
        jf.setLayout(null);

        JButton jb = new JButton("点我");
        //设置按钮位置和宽高
        jb.setBounds(100,100,100,30);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按钮被点击了");
            }
        });
        //把按钮添加到界面中
        jf.getContentPane().add(jb);




        jf.setVisible(true);//设置登录界面窗口可见
    }
}
