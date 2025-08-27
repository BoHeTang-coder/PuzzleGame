package Bohetang.test;

public class Test {
    public static void main(String[] args) {
        //按照0-15打乱顺序，并且四个一组添加到二维数组

        //1.创建一个一维数组，存储0-15
        int[] array = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        //2.打乱数组顺序
        for (int i = 0; i < array.length; i++) {
            //获取一个随机索引
            int index = (int)(Math.random() * array.length);
            //交换array[i]和array[index]
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
//        //遍历array
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }

        //3.创建一个二维数组
        int[][] array2 = new int[4][4];
        //4.将一维数组的数据存储到二维数组中
        for (int i = 0; i < array.length; i++) {
            array2[i / 4][i % 4] = array[i];
        }
        //5.遍历二维数组
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                System.out.print(array2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
