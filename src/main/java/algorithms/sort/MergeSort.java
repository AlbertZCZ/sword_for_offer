package algorithms.sort;

/**
 * @Author: zhangchaozhen
 * @Description: 归并排序
 * 把长度为n的输入序列分成两个长度为n/2的子序列；
 * 对这两个子序列分别采用归并排序；
 * 将两个排序好的子序列合并成一个最终的排序序列。
 * @Date: 2019/9/8 下午4:29
 **/
public class MergeSort {
    public static void sort(Comparable[] arr) {
        //创建一个等长的临时数组，避免频繁开辟空间
        Comparable[] temp = new Comparable[arr.length];
        sort(arr,0,arr.length - 1,temp);
    }

    private static void sort(Comparable[] arr,int left,int right,Comparable[] temp) {
        if (left < right) {
            int middle = (right + left) / 2;
            //左边归并排序，使得左子序列有序
            sort(arr,left,middle,temp);
            //右边归并排序，使得右子序列有序
            sort(arr,middle + 1,right,temp);
            //将两个有序子数组合并操作
            merge(arr,left,middle,right,temp);
        }
    }

    private static void merge(Comparable[] arr, int left, int middle, int right, Comparable[] temp) {
        //左序列指针
        int i = left;
        //右序列指针
        int j = middle + 1;
        //临时数组指针
        int t = 0;
        while (i <= middle && j <= right) {
            //将两部分中最小的一次赋值到temp
            if (arr[i].compareTo(arr[j]) <= 0) {
                temp[t++] = arr[i++];
            }else if (arr[i].compareTo(arr[j]) > 0) {
                temp[t++] = arr[j++];
            }
        }
        //将左边剩余元素填充进temp中
        while (i <= middle) {
            temp[t++] = arr[i++];
        }
        //将右序列剩余元素填充进temp中
        while (j <= right) {
            temp[t++] = arr[j++];
        }

        //将temp中的元素全部拷贝到原数组中 ? arr = Arrays.copyOf(temp, temp.length);
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

    public static void main(String[] args) {
        Integer[] integers = SortTestHelper.generateRandomArray(20, 0, 20);
        SortTestHelper.printArray(integers);
        SortTestHelper.testSort("algorithms.sort.MergeSort",integers);
        SortTestHelper.printArray(integers);
    }

}
