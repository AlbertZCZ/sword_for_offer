package sword.offer;

import sword.offer.tools.TreeNode;

/**
 * @Author:Zhangchaozhen
 * @Date: Create in 2018/4/3 22:08
 * @Description: 得到二叉树的镜像
 */
public class Interview19 {
    /**
     *
     * @param root 二叉树根节点
     */
    public static TreeNode mirror(TreeNode root) {
        if (root == null)
            return root;

        //交换两个子树
        TreeNode temp = new TreeNode();
        temp = root.left;
        root.left = root.right;
        root.right = temp;

        //对结点的左右两个子树进行处理
        mirror(root.left);
        mirror(root.right);
        return root;
    }

}
