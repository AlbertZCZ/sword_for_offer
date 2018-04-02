package sword.offer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author:Zhangchaozhen
 * @Date: Create in 2018/3/28 16:54
 * @Description: 输入数字n，按顺序打印出从1到n位最大的十进制数。比如输入3则打印1,2,3,4....998,999.
 * 考察对大数溢出问题的处理
 * 将其转为字符串模拟数字加法
 */
public class Interview12 {
    public static void printOneToNthDigits(int n) {
        //非法输入判断
        if (n <= 0)
            throw new RuntimeException("n应该大于0");
        //用nlist表示数n,nlist[0]表示n的最低位
        List<Integer> nList = new ArrayList<>();
        for (int i = 0;i < n;i++) {
            nList.add(0);
        }
        increment(nList);

    }

    /**
     * 使数字每次+1然后输出
     * @param nlist n位数字
     */
    private static void increment(List<Integer> nlist) {
        int carrybit = 0;//进位数
        boolean end = false;//结束循环标志
        while (true) {
            for (int i = nlist.size() - 1; i >= 0; i--) {
                int digit = nlist.get(i);
                int sum = digit + carrybit;
                //从最低位加一
                if (i == (nlist.size() - 1)) {
                    sum += 1;
                }
                if (sum >= 10) {
                    // 最高位产生进位，达到最大值，停止输出
                    if (i == 0) {
                        end = true;
                    }
                    sum = sum - 10;
                    carrybit = 1;
                } else {
                    carrybit = 0;
                }
                nlist.set(i, sum);
            }
            output(nlist);
            if (end) {
                break;
            }
        }

    }

    /**
     * 输出数字，将高位的0舍掉
     * @param nlist
     */
    private static void output(List<Integer> nlist) {
        Iterator<Integer> ite = nlist.iterator();
        int num;

        boolean first = false;
        while (ite.hasNext()) {
            if (first) {
                System.out.print(ite.next());
                continue;
            }
            //找到第一个不为0的位置
            if ((num = ite.next()) != 0) {
                first = true;
                System.out.print(num);
            }
        }

        System.out.println();
    }

    /*****************************************************************************/
    /**
     * 全排列
     * 数字的每一位都可能是0~9中的一个数
     * @param n
     */
    public static void printOneToNthDigits2(int n) {
        if (n <= 0)
            throw new RuntimeException("n不能小于1");
        //创建一个数组用于打存放值
        int[] array = new int[n];
        printOneToNthDigits2(0, array);
    }

    /**
     * 输入数字n，按顺序打印出从1最大的n位十进制数。
     * @param n 当前处理的是第个元素，从0开始计数
     * @param array 存放结果的数组
     */
    private static void printOneToNthDigits2(int n, int[] array) {
        //// 说明所有的数据排列选择已经处理完了
        if (n >= array.length)
            //可以输出
            printArray(array);
        else {
            //每一位都有0~9种可能
            for (int i = 0;i <= 9;i++) {
                array[n] = i;
                printOneToNthDigits2(n + 1,array);
            }
        }
    }

    /**
     * 输入数组的元素，从左到右，从第一个非0值到开始输出到最后的元素。
     *
     * @param array 要输出的数组
     */
    private static void printArray(int[] array) {
        //找第一个非0元素
        int index = 0;
        while (index < array.length && array[index] == 0)
            index++;

        //从第一个非0元素开始输出到最后一个元素
        for (int i = index;i < array.length;i++) {
            System.out.print(array[i]);
        }
        //换行
        if (index < array.length)
            System.out.println();
    }

}
