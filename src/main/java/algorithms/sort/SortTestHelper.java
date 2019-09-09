package algorithms.sort;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author: zhangchaozhen
 * @Description: 测试排序算法工具类
 * @Date: 2019/9/6 下午10:49
 **/
public class SortTestHelper {


    public static void swap(Comparable[] arr, int i, int j) {
        Comparable t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /**
     * 生成有n个元素的随机数组,每个元素的随机范围为[begin, end]
     * @param n
     * @param begin
     * @param end
     * @return
     */
    public static Integer[] generateRandomArray(int n,int begin,int end) {
        Integer[] arry = new Integer[n];
        for (int i = 0; i < n; i++) {
            arry[i] = (int)(Math.random() * (end - begin + 1 + begin));
        }
        return arry;
    }

    /**
     * 生成一个近乎有序的数组
     *  首先生成一个含有[0...n-1]的完全有序数组, 之后随机交换swapTimes对数据
     *  swapTimes定义了数组的无序程度:
     *  swapTimes == 0 时, 数组完全有序
     *  swapTimes 越大, 数组越趋向于无序
     * @param n
     * @param swapTimes
     * @return
     */
    public static Integer[] generateNearlyOrderedArray(int n, int swapTimes){

        Integer[] arr = new Integer[n];
        for( int i = 0 ; i < n ; i ++ ) {
            arr[i] = i;
        }

        for( int i = 0 ; i < swapTimes ; i ++ ){
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }

        return arr;
    }

    public static void printArray(Object[] arr) {
        Arrays.asList(arr).forEach(System.out::println);
    }

    /**
     * 判断数组是否有序
     * @param arr
     * @return
     */
    public static boolean isSorted(Comparable[] arr){
        for( int i = 0 ; i < arr.length - 1 ; i ++ ) {
            if( arr[i].compareTo(arr[i+1]) > 0 ) {
                return false;
            }
        }
        return true;
    }

    public static void testSort(String sortClassName, Comparable[] arr){
        try {
            // 通过sortClassName获得排序函数的Class对象
            Class<?> clazz = Class.forName(sortClassName);
            // 通过排序函数的Class对象获得排序方法
            Method sortMethod =  clazz.getMethod("sort", Comparable[].class);
            // 排序参数只有一个，是可比较数组arr
            Object[] params = new Object[]{arr};
            long startTime = System.currentTimeMillis();
            // 调用排序函数
            sortMethod.invoke(null,params);
            long endTime = System.currentTimeMillis();

            assert isSorted( arr );

            System.out.println( clazz.getSimpleName()+ " : " + (endTime-startTime) + "ms" );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
