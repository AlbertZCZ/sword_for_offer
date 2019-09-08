package algorithms;

/**
 * @Author: zhangchaozhen
 * @Description: 希尔排序
 * 希尔排序是把记录按下表的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止。
 * @Date: 2019/9/8 下午2:31
 **/
public class ShellSort {

    public static void sort(Comparable[] arr) {
        int length = arr.length;
        //计算增量h
        int h = 1;
        while (h < length / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            //分段插入排序
            for (int i = h; i < length; i++) {
                Comparable e = arr[i];
                int j = i;
                for (;j >= h && e.compareTo(arr[j-h]) < 0;j -= h ) {
                    arr[j] = arr[j-h];
                }
                //如果进上面循环，j会执行一次j -= h
                arr[j] = e;
            }
            //改变增量
            h /= 3;
        }
    }

    public static void main(String[] args) {
        Integer[] integers = SortTestHelper.generateRandomArray(10, 1, 100);
        SortTestHelper.printArray(integers);
        SortTestHelper.testSort("algorithms.ShellSort",integers);
        SortTestHelper.printArray(integers);
    }
}
