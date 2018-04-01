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

}
