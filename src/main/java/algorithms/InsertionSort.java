package algorithms;

/**
 * @Author: zhangchaozhen
 * @Description: 插入排序，慢于选择排序
 * @Date: 2019/9/6 下午11:40
 **/
public class InsertionSort {
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        //i之前的元素都以从小到大的顺序排好，不包括i
        for (int i = 1; i < n; i++) {
            //e是要排序的那个元素
            Comparable e = arr[i];
            int j = i;
            //如果e小于之前的元素就要往前循环
            for( ; j > 0 && arr[j-1].compareTo(e) > 0 ; j--) {
                //将之前元素向后移，将j的指针向前移动一位
                arr[j] = arr[j-1];
            }
            //如果进上面循环，j会执行一次j--
            //将e插入索引j的位置
            arr[j] = e;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = SortTestHelper.generateRandomArray(20000, 0, 100000);
        SortTestHelper.testSort("algorithms.InsertionSort", arr);
    }
}
