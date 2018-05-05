package sword.offer;

import sword.offer.tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zhangchaozhen
 * @Date: 2018/5/5 下午2:22
 * @Description: 从上往下打印出二叉树的每个结点，向一层的结点按照从左往右的顺序打印。
 *      例如下的二叉树，
 *            8
 *         /    \
 *        6     10
 *       /  \   / \
 *      5   7  9  11
 *      则依次打印出8、6、10、5、3 、9、11.
 *
 */
public class Interview23 {

    /**
     * 经分析得出 当遍历某个节点时如果该节点有子节点，则将该节点的左、右节点依次放入队列
     * @param root
     */
    public static void printFromToBottom(TreeNode root) {

        //非空判断
        if (root != null) {
            //用于存放还未遍历元素的队列
            Queue<TreeNode> list = new LinkedList<>();
            //将根节点入队列
            list.add(root);
            //记录当前处理的节点
            TreeNode currentNode = root;
            //如果队列里有元素则进行处理
            while (!list.isEmpty()) {
                //出对操作
                currentNode = list.remove();
                //打印对首节点
                System.out.println(currentNode.value);
                //如果当前节点有左子节点，入队
                if (currentNode.left != null)
                    list.add(currentNode.left);

                //如果当前节点有右子节点，入队
                if (currentNode.right != null)
                    list.add(currentNode.right);
            }
        }
    }
}
