package sword.offer;

/**
 * @Author:Zhangchaozhen
 * @Date: Create in 2018/3/27 11:10
 * @Description: 把一个数组最开始的若干个元素搬到数组的末尾， 我们称之数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3, 4, 5, 1, 2｝为｛1 ,2, 3, 4, 5}的一个旋转，该数组的最小值为
 */
public class Interview08 {
    //旋转数组实际上是两个有序数组，其分界线为最小元素
    //可以用二分法查找
    public static int min(int[] numbers) {
        //判断输入是否合法
        if (numbers == null || numbers.length == 0) {
            throw new RuntimeException("数组为空");
        }
        int start = 0;//前指针
        int end = numbers.length - 1;//后指针
        //旋转了0个元素
        if (numbers[start] < numbers[end]) {
            return numbers[start];
        }
        // 确保start在前一个排好序的部分，end在排好序的后一个部分,当两个指针相邻作为循环终止条件
        while ((end - start > 1) && (numbers[start] >= numbers[end])) {
            int mid = (end + start) / 2;

            // 如果三个数都相等，则需要进行顺序处理，从头到尾找最小的值
            if (numbers[start] == numbers[mid] && numbers[mid] == numbers[end]) {
                return minInorder(numbers, start, end);
            }
            // 如果中间位置对应的值在前一个排好序的部分，将start设置为新的处理位置
            if (numbers[start] < numbers[mid]) {
                start = mid;
            }
            // 如果中间位置对应的值在后一个排好序的部分，将end设置为新的处理位置
            if (numbers[mid] < numbers[end]) {
                end = mid;
            }
        }

        return numbers[end];
    }

    /**
     * 顺序查找最小值
     * @param numbers 数组
     * @param start 开始位置
     * @param end 结束位置
     * @return 找到的最小的数
     */
    private static int minInorder(int[] numbers, int start, int end) {
        int result = numbers[start];
        for (int i = start + 1; i <= end; i++) {
            if (result > numbers[i]) {
                result = numbers[i];
            }
        }
        return result;
    }

}
