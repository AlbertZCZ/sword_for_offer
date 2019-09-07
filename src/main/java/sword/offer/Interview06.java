package sword.offer;

/**
 * @Author:Zhangchaozhen
 * @Date: Create in 2018/3/26 14:52
 * @Description: 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class Interview06 {
    /**
     * 二叉树结构
     */
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value, TreeNode left,TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /**
     *
     * @param preorder 前序遍历数组
     * @param ps 前序遍历开始位置
     * @param pe 前序遍历结束位置
     * @param inorder 中序遍历数组
     * @param is 中序遍历开始位置
     * @param ie 中序遍历结束位置
     * @return 树的根结点
     */
    public static TreeNode construct(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        //开始位置大于结束位置说明没有需要处理的元素了
        if (ps > pe) {
            return null;
        }
        //前序遍历结果的开始位置即为根元素
        int index = ps;
        TreeNode root = new TreeNode(preorder[index],null,null);
        //获取根元素在中序遍历中的位置
        int i = is;
        for (;i < ie;i++) {
            if (inorder[i] == preorder[index]) {
                break;
            }
        }

        if (i > ie) {
            return null;
        }

        // 递归构建当前根结点的左子树，左子树的元素个数：index-is+1个
        // 左子树对应的前序遍历的位置在[ps+1, ps+index-is],下标=个数-1
        // 左子树对应的中序遍历的位置在[is, index-1]
        root.left = construct(preorder,ps + 1,ps + i - is,inorder,is,i - 1);
        // 递归构建当前根结点的右子树，右子树的元素个数：ie-index个
        // 右子树对应的前序遍历的位置在[ps+index-is+1, pe]
        // 右子树对应的中序遍历的位置在[index+1, ie]
        root.right = construct(preorder,ps + i - is + 1,pe ,inorder,i + 1,ie);
        return root;
    }

    /**
     * 中序遍历二叉树
     * @param node 根结点
     */
    public static void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.value + ",");
            inOrder(node.right);
        }
    }

    /**
     * 后序遍历二叉树
     * @param node 根结点
     */
    public static void afterOrder(TreeNode node) {
        if (node != null) {
            afterOrder(node.left);
            afterOrder(node.right);
            System.out.println(node.value);
        }
    }
}
