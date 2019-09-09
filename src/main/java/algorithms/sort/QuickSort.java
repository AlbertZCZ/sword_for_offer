package algorithms.sort;

/**
 * @Author: zhangchaozhen
 * @Description: 快速排序
 * @Date: 2019/9/9 下午10:29
 **/
public class QuickSort {
    public static void sort(Comparable[] arr) {
        quickSort(arr,0,arr.length - 1);
    }

    public static void quickSort(Comparable[] arr,int l,int r) {

        if (l < r) {
            int i = l;
            int j = r;
            //基准数
            Comparable e = arr[l];

            while (i < j) {
                //首先从右往左找小于e的值
                while (i < j && arr[j].compareTo(e) > 0) {
                    j--;
                }
                //1.当找到比基准数小的值
                //2.把该值移到左边（赋值给i，因一开始i的值即为e所以不会丢失）
                //3.然后从左向右找大于基准数的数
                if (i < j) {
                    arr[i++] = arr[j];
                }
                while (i < j && arr[i].compareTo(e) < 0) {
                    i++;
                }
                //1.当找到比基准数大的值
                //2.把该值移到右边（赋值给j，因上一步j的值已经赋给i，所以不会丢失）
                //3.然后换方向继续
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }
            //最终将基准值赋给i
            arr[i] = e;

            //继续递归进行i左右两边
            quickSort(arr,l,i - 1);
            quickSort(arr,i + 1,r);
        }
    }

    public static void main(String[] args) {
        Integer[] integers = SortTestHelper.generateRandomArray(20, 0, 200);
        SortTestHelper.printArray(integers);
        SortTestHelper.testSort("algorithms.sort.QuickSort",integers);
        SortTestHelper.printArray(integers);
    }
}
