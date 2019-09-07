package algorithms;

/**
 * 选择排序
 * @author zhangchaozhen
 */
public class SelectionSort {

    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 寻找[i, n)区间里的最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            SortTestHelper.swap(arr,minIndex,i);
    }
}

    public static void main(String[] args) {
        Integer[] integers = SortTestHelper.generateRandomArray(20000, 0, 100000);
        SortTestHelper.testSort("algorithms.SelectionSort",integers);
    }
}
