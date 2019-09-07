package algorithms;

/**
 * @Author: zhangchaozhen
 * @Description: 冒泡优化，如果对于一个本身有序的序列，或则序列后面一大部分都是有序的序列，上面的算法就会浪费很多的时间开销，
 * 这里设置一个标志flag，如果这一趟发生了交换，则为true，否则为false。明显如果有一趟没有发生交换，说明排序已经完成。
 * @Date: 2019/9/7 下午2:30
 **/
public class BubbleSort2 {
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        //是否继续循环的标志
        int flag;

        do {
            //每次外层循环标记都置位0
            flag = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    SortTestHelper.swap(arr,i -1,i);
                    //没有进if说明后续都是有序的，记录交换的最大索引
                    flag = i;
                }
            }
            n = flag;
        }while (flag > 0);

    }

    public static void main(String[] args) {
        Integer[] integers = SortTestHelper.generateRandomArray(20000, 0, 100000);
        SortTestHelper.testSort("algorithms.BubbleSort2",integers);
    }
}
