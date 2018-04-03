package sword.offer.tools;

/**
 * @Author: Zhangchaozhen
 * @Date: Create in 2018/4/2 17:44
 * @Description: 二叉树根节点
 */
public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    /**
     * 打印一颗二叉树
     * @param root
     */
    public static void printTree(TreeNode root) {
        if (root != null) {
            System.out.println(root.value);
            printTree(root.left);
            printTree(root.right);
        }
    }
    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", left=" + left.value +
                ", right=" + right.value +
                '}';
    }
}
