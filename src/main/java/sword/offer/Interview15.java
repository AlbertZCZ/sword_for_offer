package sword.offer;

import sword.offer.tools.ListNode;

/**
 * @Author:Zhangchaozhen
 * @Date: Create in 2018/4/2 14:16
 * @Description: 输出链表的倒数第k个节点
 * 考察对链表的理解及代码健壮性！
 */
public class Interview15 {
    /**
     * 定义两个指针，第一个指针先移动k-1步第二个指针开始移动，当第一个指针移到末尾时
     * 第二个指针刚好指向倒数第k个节点
     * @param head 头节点
     * @param k 倒数第k个节点
     * @return
     */
    public static ListNode findKthToTail(ListNode head,int k) {
        //输入的链表不能为空且k大于0
        if (head == null || k <= 0) {
            return null;
        }
        //指向头结点
        ListNode pointer = head;
        //pointer先走k-1个位置
        for (int i = 1;i < k;i++) {
            //说明还有节点
            if (pointer != null) {
                pointer = pointer.next;
            }else {//已经没有节点了，但是i还没有到达k-1说明k太大，链表中没有那么多的元素
                return null;
            }
        }
        // 当pointer走到最后一个结点即，pointer.next=null时，head就是倒数第k个结点
        while (pointer.next != null) {
            head = head.next;
            pointer = pointer.next;
        }
        return head;
    }
}
