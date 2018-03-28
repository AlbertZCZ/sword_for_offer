package sword.offer;

/**
 * @Author: Zhangchaozhen
 * @Date: 3/27/18 11:28 PM
 * @Descriptoin: 实现函数double Power(double base, int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 *注：在计算机内表示小数时（float，double）都有误差。判断两个小数是否相等，只能判断它们之差的绝对值是不是在一个很小的范围内。
 * 如果之差很小，就可以认为它们相等。
 **/
public class Interview11 {
    /**
     *
     * @param base 低数
     * @param exponent 幂
     * @return 结果
     */
    public static double power(double base, int exponent) {
        // 指数为0就返回1
        if (exponent == 0)
            return 1;
        if (exponent < 0 && equal(base,0))
            throw new RuntimeException("0的负数次幂没有意义");

        // 求指数的绝对值
        long exp = exponent;
        if (exponent < 0) {
            exp = -exp;
        }

        double result = powerWithUnsignedExponent(base, exp);
        //如果指数为负，结果为其倒数
        if (exponent < 0) {
            result = 1 / result;
        }

        return result;
    }

    /**
     * 求一个数的正整数次幂，不考虑溢出
     * @param base  指次
     * @param exp 幂
     * @return 结果
     */
    private static double powerWithUnsignedExponent(double base, long exp) {
        // 如果指数为0，返回1
        if (exp == 0) {
            return 1;
        }

        // 指数为1，返回底数
        if (exp == 1) {
            return base;
        }
        double result = 1;
        for (int i = 1;i <= exp;i++) {
            result *= base;
        }
        return result;
    }

    /**
     * 判断两个浮点型数字是否相等
     * @param num1
     * @param num2
     * @return
     */
    private static boolean equal(double num1,double num2) {
        if ((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001))
            return true;
        return false;
    }
}
