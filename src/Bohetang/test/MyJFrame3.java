package Bohetang.test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class MyJFrame3 extends JFrame implements KeyListener {

        public MyJFrame3() {
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

            this.addKeyListener(this);

            this.setVisible(true);//设置登录界面窗口可见
        }

    @Override
    public void keyTyped(KeyEvent e) {

    }
//1.如果按下一个按键没有松开，会重复触发
    //2.键盘里那么多按键，每个按键对应一个编号，可以通过KeyEvent的getKeyCode方法获取
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开");
        int code = e.getKeyCode();
        if (code == 65) {
            System.out.println("按下的是A键");
        } else if (code == 66) {
            System.out.println("按下的是B键");
        } else if (code == 67) {
            System.out.println("按下的是C键");
        }
    }
}
