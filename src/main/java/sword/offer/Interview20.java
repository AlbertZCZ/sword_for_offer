package sword.offer;

/**
 * @Author:Zhangchaozhen
 * @Date: Create in 2018/4/3 22:37
 * @Description: 顺时针打印矩形
 */
public class Interview20 {
    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印每一个数字
     * @param numbers 输入的二维数组,二维数组必须是N*M的，否则分出错
     */
    public static void printMatrixClockWisely(int[][] numbers) {
        //非法参数判断
        if (numbers == null)
            return;
        // 记录一圈（环）的开始位置的行
        int x = 0;
        // 记录一圈（环）的开始位置的列
        int y = 0;
        //让循环结束的条件是columns>startX * 2 && rows > startY * 2
        //对每一圈进行处理
        //行号最大的是numbers.length - 1
        //列号最大的是numbers[0].length - 1
        while (x * 2 < numbers.length && y * 2 < numbers[0].length) {
            printMatrixInCircle(numbers, x, y);
            // 指向下一个要处理的的环的第一个位置
            x++;
            y++;
        }
    }

    /**
     * 打印一圈
     * @param numbers 二维数组
     * @param x 起始行数
     * @param y 起始列数
     */
    private static void printMatrixInCircle(int[][] numbers, int x, int y) {
        int endX = numbers.length - 1 - x;
        int endY = numbers[0].length - 1 - y;
        //从左向右打印一行,行数不变列数加一
        for (int i = y;i <= endY;i++) {
            System.out.println(numbers[x][i]);
        }
        //从上到下打印一列
        if (endX > x) {
            for (int i = x + 1;i <= endX;i++) {
                //列数不变，行数加一
                System.out.println(numbers[i][endY]);
            }
        }
        //从右到左打印一行
        if (endY > y && endX > x) {
            for (int i = endY - 1;i >= y;i--) {
                //行数不变，列数减一
                System.out.println(numbers[endX][i]);
            }
        }
        //从下到上打印一列
        if (endY - y > 1 && endX > x) {
            for (int i = endX - 1;i > x;i--) {
                //列数不变行数减一
                System.out.println(numbers[i][y]);
            }
        }
    }
}
