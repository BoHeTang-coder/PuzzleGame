package Bohetang.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    //GameJFrame表示游戏的主界面，跟游戏主界面相关的代码都写在这个类中
    //1.创建游戏的主界面
    //3.创建一个二维数组 加载图片的时候会根据二维数组的数字加载图片
    int[][] data = new int[4][4];
    //记录空白方块
    int x = 0;
    int y = 0;

    int step = 0; //记录步数

    //创建功能选项上的三个小选项 重新登录，重新游戏，关闭游戏
    JMenuItem reLoginJMenuItem = new JMenuItem("重新登录");
    JMenuItem reGameJMenuItem = new JMenuItem("重新游戏");
    JMenuItem closeGameJMenuItem = new JMenuItem("关闭游戏");

    JMenuItem accountJMenuItem = new JMenuItem("Github");

    JMenuItem anime = new JMenuItem("动漫");
    JMenuItem beauty = new JMenuItem("人物");
    JMenuItem sport = new JMenuItem("运动");
    
    //定义一个变量，记录当前的展示图片的路径
    String path = "D:\\Code\\JavaSE\\JavaSE\\PuzzleGame\\image\\anime\\anime4\\";

    //定义一个二维数组，存储游戏胜利时的状态
    int[][] win = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };


    public GameJFrame() {
        //在创建对象的同时，完成界面的初始化工作
        initJFrame();

        //初始化菜单
        initJMenuBar();

        //初始化数据
        initData();

        //初始化图片
        initImage();

        //设置游戏主界面窗口可见
        this.setVisible(true);

    }

    //初始化数据
    //按照0-15打乱顺序，并且四个一组添加到二维数组
    private void initData() {
        //1.创建一个一维数组，存储0-15
        int[] tempArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //2.打乱数组顺序
        for (int i = 0; i < tempArray.length; i++) {
            //获取一个随机索引
            int index = (int) (Math.random() * tempArray.length);
            //交换array[i]和array[index]
            int temp = tempArray[i];
            tempArray[i] = tempArray[index];
            tempArray[index] = temp;
        }
//
        //3.将一维数组的数据存储到二维数组中
        for (int i = 0; i < tempArray.length; i++) {
            if (tempArray[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
                data[i / 4][i % 4] = tempArray[i];
        }
    }

    //初始化图片
    //添加图片的时候，按照二维数组的数字加载图片
    private void initImage() {
        this.getContentPane().removeAll(); //清除原有图片
        if(victory()){
            //胜利
            JLabel winJLabel = new JLabel(new ImageIcon( "D:\\Code\\JavaSE\\JavaSE\\PuzzleGame\\image\\win.png"));
            winJLabel.setBounds(203, 283, 197, 73);
            this.getContentPane().add(winJLabel);
        }

        JLabel stepCount = new JLabel("步数：" + step);
        stepCount.setBounds(50,30,100,20);
        this.getContentPane().add(stepCount);

        //重新加载图片
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = data[i][j];
                //创建一个标签JLabel对象
                JLabel jLabel = new JLabel(new ImageIcon(path + num + ".png"));
                //指定图片位置
                jLabel.setBounds(105 * j + 80, 105 * i + 135, 105, 105);
                //设置边框
                //1:凹陷 0:凸起
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                //将图片添加到标签中
                this.getContentPane().add(jLabel);
            }

        }

        //添加背景图片
        ImageIcon bg = new ImageIcon("D:\\Code\\JavaSE\\JavaSE\\PuzzleGame\\image\\background.png");
        JLabel background = new JLabel(bg);
        background.setBounds(40, 40, 508, 560);
        //将背景图片添加到界面中
        this.getContentPane().add(background);


        //刷新界面
        this.getContentPane().repaint();
    }

    private void initJMenuBar() {
        //创建整个的菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单上的两个选项对象 功能和关于我们
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于");
        //更换图片
        JMenu changePicJMenu = new JMenu("更换图片");


       

        //将小选项添加到功能选项上
        functionJMenu.add(reLoginJMenuItem);
        functionJMenu.add(reGameJMenuItem);
        functionJMenu.add(closeGameJMenuItem);

        //将小选项添加到关于我们选项上
        aboutJMenu.add(accountJMenuItem);

        //把更换图片的三个选项添加到更换图片的菜单上
        changePicJMenu.add(anime);
        changePicJMenu.add(beauty);
        changePicJMenu.add(sport);

        //将更换图片的菜单添加到功能菜单上
        functionJMenu.add(changePicJMenu);
        //给条目绑定事件

        //调用actionPerformed方法
        reGameJMenuItem.addActionListener(this); 
        closeGameJMenuItem.addActionListener(this);
        reLoginJMenuItem.addActionListener(this);
        accountJMenuItem.addActionListener(this);
//        changePicJMenu.addActionListener(this);
        anime.addActionListener(this);
        beauty.addActionListener(this);
        sport.addActionListener(this);

        //将两个选项添加到菜单上
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //将菜单添加到界面上
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        //在创建对象的同时，完成界面的初始化工作
        //1.设置界面的宽高
        this.setSize(600, 680);   //设置游戏主界面窗口的宽高
        //2.设置界面标题
        this.setTitle("拼图游戏单机版 v1.0");    //设置游戏主界面窗口的标题
        //3.设置界面置顶
        this.setAlwaysOnTop(true);   //设置游戏主界面窗口置顶
        //4.设置界面居中
        this.setLocationRelativeTo(null); //设置游戏主界面窗口居中
        //5.设置关闭模式
        this.setDefaultCloseOperation(3); //设置游戏主界面窗口关闭模式
        //6.取消默认的居中放置,这样才能按照XY轴的坐标进行放置
        this.setLayout(null);
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //按下不松时调用该方法
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == 32) {
            this.getContentPane().removeAll();
            //加载第一张完整的图片
            JLabel all = new JLabel(new ImageIcon(path + "all.png"));
            all.setBounds(80, 135, 420, 420);
            this.getContentPane().add(all);
            //添加背景图片
            ImageIcon bg = new ImageIcon("D:\\Code\\JavaSE\\JavaSE\\PuzzleGame\\image\\background.png");
            JLabel background = new JLabel(bg);
            background.setBounds(40, 40, 508, 560);
            //将背景图片添加到界面中
            this.getContentPane().add(background);
            //刷新界面
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //判断游戏是否胜利，如果胜利就不能再移动
        if(victory()){
            //结束当前方法
            return;
        }
        //对上下左右按键进行判断
        //上：38
        //下：40
        //左：37
        //右：39
        int keyCode = e.getKeyCode();
        System.out.println(keyCode);
        if (keyCode == 38 || keyCode == 87) {
            System.out.println("向上移动");
            if (x == 3) {
                //表示空白方块已经在最下面一行，不能再向上移动
                return;
            }
            //把空白方块下面的数字上移
            //x,y表示空白方块
            //x+1，y表示空白方块下面的数字
            //交换
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            //更新x,y的值
            x++;
            step++;
            //重新加载图片
            initImage();
        } else if (keyCode == 40 || keyCode == 83) {
            System.out.println("向下移动");
            if (x == 0) {
                //表示空白方块已经在最上面一行，不能再向下移动
                return;
            }
            //把空白方块上面的数字下移
            //x,y表示空白方块
            //x-1，y表示空白方块上面的数字
            //交换
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            //更新x,y的值
            x--;
            step++;
            //重新加载图片
            initImage();
        } else if (keyCode == 37 || keyCode == 65) {
            System.out.println("向左移动");
            if (y == 3) {
                //表示空白方块已经在最右边一列，不能再向左移动
                return;
            }
            //把空白方块右面的数字左移
            //x,y表示空白方块
            //x，y+1表示空白方块上面的数字
            //交换
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            //更新x,y的值
            y++;
            step++;
            //重新加载图片
            initImage();


        } else if (keyCode == 39 || keyCode == 68) {
            System.out.println("向右移动");
            if (y == 0) {
                //表示空白方块已经在最左边一列，不能再向右移动
                return;
            }
            //把空白方块右面的数字左移
            //x,y表示空白方块
            //x，y+1表示空白方块上面的数字
            //交换
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            //更新x,y的值
            y--;
            step++;
            //重新加载图片
            initImage();
        } else if (keyCode == 32) {
            System.out.println("松开了空格键");
            //重新加载图片
            initImage();
        }
        else if (keyCode == 90 ) {
            System.out.println("按下了Z键");
            data = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0}
            };
            initImage();
            initData();
        }
    }

    //判断游戏是否胜利
    //胜利的条件：data数组和win数组完全一致
    public boolean victory() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (data[i][j] != win[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj  = e.getSource();
        if(obj == reLoginJMenuItem){
            System.out.println("重新登录");
            //关闭当前游戏界面
            this.setVisible(false);
            //打开登录界面
            new LoginJFrame();
        }
        else if(obj == reGameJMenuItem){
            System.out.println("重新游戏");
            //1.步数清零
            //应该先清零再开始游戏
            step = 0;
            //2.数据初始化
            initData();
            //3.图片加载
            initImage();
        }
        else if(obj == closeGameJMenuItem){
            System.out.println("关闭游戏");
            System.exit(0); //JVM退出，整个程序结束
        }
        else if(obj == accountJMenuItem){
            System.out.println("Github");
            //创建一个弹窗对象
            JDialog jDialog = new JDialog();
            //创建一个标签对象
            JLabel jLabel = new JLabel(new ImageIcon("D:\\Code\\JavaSE\\JavaSE\\PuzzleGame\\image\\about.png"));
            jLabel.setBounds(0,0,340,350);
            //将标签添加到弹窗中
            jDialog.getContentPane().add(jLabel);
            //设置弹窗大小
            jDialog.setSize(340,380);
            //设置弹窗标题
            jDialog.setTitle("请给BoHeTang的github点个⭐吧~");
            //设置弹窗置顶
            jDialog.setAlwaysOnTop(true);
            //设置弹窗居中
            jDialog.setLocationRelativeTo(null);
            //弹窗不关闭无法操作下面的界面
            jDialog.setModal(true);
            //设置弹窗可见
            jDialog.setVisible(true);

        }
        else if(obj == anime){
            System.out.println("动漫");
            Random r = new Random();
            int num = 1+r.nextInt(10);
            path = "D:\\Code\\JavaSE\\JavaSE\\PuzzleGame\\image\\anime\\anime" + num +"\\";
            //重新加载图片
            initData();
            initImage();
        }
        else if(obj == beauty){
            System.out.println("人物");
            Random r = new Random();
            int num = 1+r.nextInt(10);
            path = "D:\\Code\\JavaSE\\JavaSE\\PuzzleGame\\image\\beauty\\girl"+ num +"\\";
            //重新加载图片
            initData();
            initImage();
        }
        else if(obj == sport){
            System.out.println("运动");
            Random r = new Random();
            int num = 1+r.nextInt(10);
            path = "D:\\Code\\JavaSE\\JavaSE\\PuzzleGame\\image\\sport\\sport"+ num +"\\";
            //重新加载图片
            initData();
            initImage();
        }
    }
}
