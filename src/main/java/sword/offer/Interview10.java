package sword.offer;

/**
 * @Author:Zhangchaozhen
 * @Date: Create in 2018/3/27 17:37
 * @Description:  输入一个整数，输出该数二进制表示中1的个数。
 * 例如把9表示成二进制是1001 ，有2位是1. 因此如果输入9，该出2。
 * 负数以其正值的补码形式表达
 */
public class Interview10 {

    /**
     * 第一种方法
     * 首先将n和1做与运算，判断n的最低位是否为1.接着把1左移一位得到2再与n做与运算....这样反复左移
     * @param n 数字n
     * @return 1的个数
     */
    public static int numberOfOne(int n) {
        int count = 0;
        int flag = 1;

        while (flag > 0) {
            if ((n & flag) > 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    /**
     * 第二种方法，一个数减去1后就是把它最右边的1变成0，左边的保持不变，如果右边还有0都变成1。再与其本身做与运算后得到的数
     * 就是把它最右边的1变成0，循环直到值为0
     * @param n 数字n
     * @return 1的个数
     */
    public static int numberOfTwo(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n -1);
            count++;
        }
        return count;
    }
}
