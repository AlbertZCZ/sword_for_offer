package sword.offer;

import sword.offer.tools.ListNode;

/**
 * @Author:Zhangchaozhen
 * @Date: Create in 2018/4/2 16:57
 * @Description: 合并两个有序链表
 */
public class Interview17 {
    /**
     *
     * @param head1 有序链表1
     * @param head2 有序链表2
     * @return 合并后链表头节点
     */
    public static ListNode merge(ListNode head1,ListNode head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        // 创建一个临时结点，用于添加元素时方便
        ListNode root = new ListNode();
        // 用于指向合并后的新链的尾结点
        ListNode pointer = root;

        //当两个链表都不为空就进行合并操作
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                pointer.next = head1;
                head1 = head1.next;
            }else  {
                pointer.next = head2;
                head2 = head2.next;
            }
            // 将指针移动到合并后的链表的末尾
            pointer = pointer.next;
        }

        // 下面的两个if有且只一个if会内的内容会执行

        // 如果第一个链表的元素未处理完将其，接到合并链表的最后一个结点之后
        if (head1 != null)
            pointer.next = head1;
        // 如果第二个链表的元素未处理完将其，接到合并链表的最后一个结点之后
        if (head2 != null)
            pointer.next = head2;

        return root.next;
    }

    /**
     * 递归方式合并两个有序链表
     * @param head1 第一个有序链表
     * @param head2 第二个有序链表
     * @return 合并后的有序链表头
     */
    public static ListNode merge2(ListNode head1, ListNode head2) {
        // 如果第一个链表为空，返回第二个链表头结点
        if (head1 == null) {
            return head2;
        }

        // 如果第二个链表为空，返回第一个链表头结点
        if (head2 == null) {
            return head1;
        }

        ListNode temp = head1;//记录链表中较小的节点
        if (head1.value < head2.value) {
            // 如果第一个链表的头结点小，就递归处理第一个链表的下一个结点和第二个链表的头结点
            temp.next = merge2(head1.next,head2);
        }else {
            temp = head2;
            // 如果第二个链表的头结点小，就递归处理第一个链表的头结点和第二个链表的头结点的下一个结点
            temp.next = merge2(head1,head2.next);
        }
        return temp;
    }
}
