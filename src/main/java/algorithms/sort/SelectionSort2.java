package algorithms.sort;

/**
 * @Author: zhangchaozhen
 * @Description: 插入排序优化
 * @Date: 2019/9/7 上午12:05
 **/
public class SelectionSort2 {
    public static void sort(Comparable[] arr){

        int left = 0, right = arr.length - 1;
        while(left < right){
            int minIndex = left;
            int maxIndex = right;

            // 在每一轮查找时, 要保证arr[minIndex] <= arr[maxIndex]
            if(arr[minIndex].compareTo(arr[maxIndex]) > 0) {
                SortTestHelper.swap(arr, minIndex, maxIndex);
            }

            for(int i = left + 1 ; i < right; i ++) {
                if(arr[i].compareTo(arr[minIndex]) < 0) {
                    minIndex = i;
                } else if(arr[i].compareTo(arr[maxIndex]) > 0) {
                    maxIndex = i;
                }
            }

            SortTestHelper.swap(arr, left, minIndex);
            SortTestHelper.swap(arr, right, maxIndex);

            left ++;
            right --;
        }
    }

    public static void main(String[] args) {

        Integer[] arr = SortTestHelper.generateRandomArray(20000, 0, 100000);
        SortTestHelper.testSort("algorithms.sort.SelectionSort2", arr);

    }
}
