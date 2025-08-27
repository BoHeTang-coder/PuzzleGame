package Bohetang.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame extends JFrame implements ActionListener {
    //创建按钮对象
    JButton jb1  = new JButton("点我");
    //创建第二个按钮对象
    JButton jb2 = new JButton("点这里");
        public MyJFrame(){
        //1.设置界面的宽高
        this.setSize(500,500);//设置登录界面窗口的宽高
        //2.设置界面标题
        this.setTitle("事件测试");
        //3.设置界面置顶
        this.setAlwaysOnTop(true);//设置登录界面窗口置顶
        //4.设置界面居中
        this.setLocationRelativeTo(null);//设置登录界面窗口居中/
        //5.设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置登录界面窗口关闭模式
        //6.取消默认的居中放置,这样才能按照XY轴的坐标进行放置
        this.setLayout(null);

        //设置按钮位置和宽高
        jb1.setBounds(100,100,100,30);
        //给按钮添加事件监听
        jb1.addActionListener(this);

        jb2.setBounds(200,100,100,30);
        jb2.addActionListener(this);
        this.getContentPane().add(jb1);
        this.getContentPane().add(jb2);
        this.setVisible(true);//设置登录界面窗口可见
    }
    public void actionPerformed(ActionEvent e){
       //对当前按钮进行判断

        //获取当前被操作的那个按钮
        Object source = e.getSource();
        if(source == jb1){
           jb1.setSize(50,20);
    }
        else if(source == jb2){
            Random r = new Random();
            jb2.setLocation(r.nextInt(500),r.nextInt(500));
        }
    }
}
