package sword.offer;

/**
 * @Author:Zhangchaozhen
 * @Date: Create in 2018/4/2 13:47
 * @Description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分。
 */
public class Interview14 {
    /**
     * 定义两个指针，分别指向数组的第一个和最后一个元素，移动两个指针，遇到
     * 不符合条件的元素交换位置
     * @param array 输入的数组
     */
    public static void reorderOddEven(int[] array) {
        //非法判断
        if (array == null || array.length == 0) {
            throw new RuntimeException("非法参数");
        }
        // 从左向右记录偶数的位置
        int start = 0;
        // 从右向左记录奇数的位置
        int end = array.length - 1;
        while (start < end) {
            //找偶数
            while (start < end && array[start]%2 != 0) {
                start++;
            }
            //找奇数
            while (end > start && array[end]%2 == 0) {
                end--;
            }
            // 找到后就将奇数和偶数交换位置
            // 对于start=end的情况，交换不会产生什么影响
            // 所以将if判断省去了
            int tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
        }

    }

    /**
     * 输出数组信息
     * @param array 待输出数组
     */
    public static void printArray(int[] array) {
        if (array != null && array.length > 0) {
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
