package sword.offer;

import sword.offer.tools.TreeNode;

/**
 * @Author:Zhangchaozhen
 * @Date: Create in 2018/4/2 17:44
 * @Description: 输入两棵二叉树A和B，判断B是不是A的子结构。
 */
public class Interview18 {
    /**
     * 该方法是在A树中找到一个与B树的根节点相等的元素的结点，
     * 从这个相等的结点开始判断树B是不是树A的子结构，如果找到其的一个就返回，
     * 否则直到所有的结点都找完为止。
     * @param root1 树A的根结点
     * @param root2 树B的根结点
     */
    public static boolean  hasSubtree(TreeNode root1, TreeNode root2) {
        //只要两个对象是同一个就返回true,对象相同意味着左右子树都相同
        if (root1 == root2)
            return true;
        //B为空，空树是任何二叉树的子树
        if (root2 == null)
            return true;
        //B不为空A为空，返回false
        if (root1 == null)
            return false;

        //记录匹配结果
        boolean result = false;
        //如果节点值相等调用匹配方法
        if (root1.value == root2.value) {
            result = match(root1,root2);
        }
        // 如果匹配就直接返回结果
        if (result) {
            return true;
        }
        // 如果不匹配就找树A的左子结点和右子结点进行判断
        return hasSubtree(root1.left,root2) || hasSubtree(root1.right,root2);
    }

    /**
     * 从树A根结点root1和树B根结点root2开始，一个一个元素进行判断，判断B是不是A的子结构
     * @param root1 树A开始匹配的根结点
     * @param root2 树B开始匹配的根结点
     * @return true:树B是树A的子结构，false：树B是不树A的子结构
     */
    private static boolean match(TreeNode root1, TreeNode root2) {
        if (root1 == root2)
            return true;
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;

        // 如果两个结点的值相等，则分别判断其左子结点和右子结点
        if (root1.value == root2.value) {
            return match(root1.left,root2.left) && match(root1.right,root2.right);
        }
        // 结点值不相等返回false
        return false;
    }
}
