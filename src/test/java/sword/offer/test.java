package sword.offer;

/**
 * @Author: Zhangchaozhen
 * @Date: Create in 2018/3/24 18:13
 * @Description: 测试用例
 */
public class test {
    public static void test03() {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(Interview03.find(matrix,7));
    }

    public static void test04() {
        char[] string = new char[50];
        string[0] = ' ';
        string[1] = 'e';
        string[2] = ' ';
        string[3] = ' ';
        string[4] = 'r';
        string[5] = 'e';
        string[6] = ' ';
        string[7] = ' ';
        string[8] = 'a';
        string[9] = ' ';
        string[10] = 'p';
        string[11] = ' ';

        int length = Interview04.replaceBlank(string,12);
        System.out.println(string.length);
        System.out.println(new String(string, 0, length));
    }

    public static void test05() {
        Interview05.Node a = new Interview05.Node(1,null);
        a.next = new Interview05.Node(2,null);
        a.next.next = new Interview05.Node(3,null);
        a.next.next.next = new Interview05.Node(4,null);

        Interview05.printReversingly(null);
    }

    public test() {
        super();
    }

    public static void test06() {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        Interview06.TreeNode root = Interview06.construct(preorder,0,7,inorder,0,7);
        Interview06.afterOrder(root);
    }

    public static void test08() {
        // 典型输入，单调升序的数组的一个旋转
        int[] array1 = {3, 4, 5, 1, 2};
        System.out.println(Interview08.min(array1));
        // 有重复数字，并且重复的数字刚好的最小的数字
        int[] array2 = {3, 4, 5, 1, 1, 2};
        System.out.println(Interview08.min(array2));
        // 有重复数字，但重复的数字不是第一个数字和最后一个数字
        int[] array3 = {3, 4, 5, 1, 2, 2};
        System.out.println(Interview08.min(array3));
        // 有重复的数字，并且重复的数字刚好是第一个数字和最后一个数字
        int[] array4 = {1, 0, 1, 1, 1};
        System.out.println(Interview08.min(array4));
        // 单调升序数组，旋转0个元素，也就是单调升序数组本身
        int[] array5 = {1, 2, 3, 4, 5};
        System.out.println(Interview08.min(array5));
        // 数组中只有一个数字
        int[] array6 = {2};
        System.out.println(Interview08.min(array6));
        // 数组中数字都相同
        int[] array7 = {1, 1, 1, 1, 1, 1, 1};
        System.out.println(Interview08.min(array7));
        // 输入NULL
        System.out.println(Interview08.min(null));
    }

    public static void test09() {
        System.out.println(Interview09.fibonacci(0));
        System.out.println(Interview09.fibonacci(1));
        System.out.println(Interview09.fibonacci(2));
        System.out.println(Interview09.fibonacci(3));
        System.out.println(Interview09.fibonacci(4));
        System.out.println(Interview09.fibonacci(5));
    }

    public static void test10() {
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Interview10.numberOfOne(0)); // 0
        System.out.println(Interview10.numberOfOne(1)); // 1
        System.out.println(Interview10.numberOfOne(-1)); // -1
        System.out.println(Interview10.numberOfOne(Integer.MAX_VALUE)); // Integer.MAX_VALUE
        System.out.println(Interview10.numberOfOne(Integer.MIN_VALUE)); // Integer.MIN_VALUE

        System.out.println("");
        System.out.println(Interview10.numberOfTwo(0)); // 0
        System.out.println(Interview10.numberOfTwo(1)); // 1
        System.out.println(Interview10.numberOfTwo(-1)); // -1
        System.out.println(Interview10.numberOfTwo(Integer.MAX_VALUE)); // Integer.MAX_VALUE
        System.out.println(Interview10.numberOfTwo(Integer.MIN_VALUE)); // Integer.MIN_VALUE
    }

    public static void test11() {
        System.out.println(Interview11.power(2, -4));
        System.out.println(Interview11.power(2, 4));
        System.out.println(Interview11.power(2, 0));

    }

    public static void main(String[] args) {

        test11();
    }
}
