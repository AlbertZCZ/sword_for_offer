package algorithms.sort;

import java.util.Arrays;

/**
 * @Author: zhangchaozhen
 * @Description: TODO
 * @Date: 2019/9/7 下午2:50
 **/
public class Test {

    public static void main(String[] args) {
        int N = 20000;

        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr5 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("algorithms.sort.SelectionSort", arr1);
        SortTestHelper.testSort("algorithms.sort.InsertionSort", arr2);
        SortTestHelper.testSort("algorithms.sort.BubbleSort2", arr3);
        SortTestHelper.testSort("algorithms.sort.ShellSort", arr4);
        SortTestHelper.testSort("algorithms.sort.MergeSort", arr5);

        System.out.println();


        // 测试2 测试近乎有序的数组
        int swapTimes = 100;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);
        //swapTimes越小，数组越趋近于有序
        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);
        arr5 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("algorithms.sort.SelectionSort", arr1);
        SortTestHelper.testSort("algorithms.sort.InsertionSort", arr2);
        SortTestHelper.testSort("algorithms.sort.BubbleSort2", arr3);
        SortTestHelper.testSort("algorithms.sort.ShellSort", arr4);
        SortTestHelper.testSort("algorithms.sort.MergeSort", arr5);
    }
}
