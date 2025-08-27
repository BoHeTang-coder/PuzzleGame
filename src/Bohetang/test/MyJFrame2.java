package Bohetang.test;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFrame2 extends JFrame implements MouseListener {
    //创建按钮对象
    JButton jb1  = new JButton("点我");
    public MyJFrame2() {
        //1.设置界面的宽高
        this.setSize(500, 500);//设置登录界面窗口的宽高
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
        jb1.setBounds(100, 100, 100, 30);
        //给按钮添加鼠标事件监听
        jb1.addMouseListener(this);
        this.getContentPane().add(jb1);
        this.setVisible(true);//设置登录界面窗口可见
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("单击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("划出");
    }
}
