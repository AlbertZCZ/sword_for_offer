package sword.offer;

/**
 * @Author:Zhangchaozhen
 * @Date: Create in 2018/3/27 15:04
 * @Description: 输入n，求斐波那契（Fibonacci) 数列的第n项
 */
public class Interview09 {
    public static long fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        // 记录前两个（第n-2个）的Fibonacci数的值
        long prePre = 1;
        // 记录前两个（第n-1个）的Fibonacci数的值
        long pre = 1;
        // 记录前两个（第n个）的Fibonacci数的值
        long current = 2;
        for (int i = 3;i <= n;i++) {
            // 求第i个的Fibonacci数的值
            current = pre + prePre;
            // 更新记录的结果，prePre原先记录第i-2个Fibonacci数的值
            // 现在记录第i-1个Fibonacci数的值
            prePre = pre;
            // 更新记录的结果，pre原先记录第i-1个Fibonacci数的值
            // 现在记录第i个Fibonacci数的值
            pre = current;
        }
        return current;
    }
}
