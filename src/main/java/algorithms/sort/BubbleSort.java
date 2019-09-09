package algorithms.sort;

/**
 * @Author: zhangchaozhen
 * @Description: 冒泡排序
 * @Date: 2019/9/7 下午2:21
 **/
public class BubbleSort {
    public static void sort(Comparable[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (arr[i].compareTo(arr[j]) < 0) {
                    SortTestHelper.swap(arr,i,j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] integers = SortTestHelper.generateRandomArray(20000, 0, 100000);
        SortTestHelper.testSort("algorithms.sort.BubbleSort",integers);
    }
}
