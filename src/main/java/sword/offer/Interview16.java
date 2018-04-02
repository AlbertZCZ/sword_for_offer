package sword.offer;

import sword.offer.tools.ListNode;

/**
 * @Author:Zhangchaozhen
 * @Date: Create in 2018/4/2 16:01
 * @Description: 翻转链表
 */
public class Interview16 {
    /**
     * 定义三个指针方法,head为中间指针
     * @param head 要翻转链表的头节点
     * @return 翻转后链表头节点
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;//上一个指针
        ListNode next;//下一个指针，需在循坏里面赋值
        while (head != null) {//head为空时，prev指向最后一个节点
            next = head.next;
            head.next = prev;//A的指针指向上一个节点
            prev = head;//向后移动prev指针
            head = next;//向后移动head指针
        }
        return prev;
    }
}
