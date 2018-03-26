package sword.offer;

/**
 * @Author: Zhangchaozhen
 * @Date: Create in 2018/3/24 18:13
 * @Description: 测试用例
 */
public class test {
    public static void main(String[] args) {

        test06();
    }

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

    public static void test06() {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        Interview06.TreeNode root = Interview06.construct(preorder,0,7,inorder,0,7);
        Interview06.afterOrder(root);
    }
}
