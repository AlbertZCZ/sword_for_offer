package sword.offer;

/**
 * @Author:Zhangchaozhen
 * @Date: Create in 2018/4/2 11:43
 * @Description: 给定单向链表的头指针和一个结点指针，定义一个函数在0(1)时间删除该结点,
 * 注意1：这个方法和文本上的不一样，书上的没有返回值，这个因为JAVA引用传递的原因，
 * 如果删除的结点是头结点，如果不采用返回值的方式，那么头结点永远删除不了】
 * 注意2：输入的待删除结点必须是待链表中的结点，否则会引起错误，这个条件由用户进行保证】
 */
public class Interview13 {

    /**
     * 链表结点
     */
    public static class ListNode {
        int value; // 保存链表的值
        ListNode next; // 下一个结点
    }

    /**
     *
     * @param head 链表表的头
     * @param toBeDeleted 待删除的结点
     * @return 删除后的头结点
     */
    public static ListNode deleteNode(ListNode head, ListNode toBeDeleted) {
        //非法输入判断
        if (head == null || toBeDeleted == null)
            return head;
        //如果删除的是头结点，直接返回下一个结点
        if (toBeDeleted == head) {
            return head.next;
        }
        // 下面的情况链表至少有两个结点

        // 在多个节点的情况下，如果删除的是最后一个元素
        if (toBeDeleted.next == null) {
            // 找待删除元素的前驱
            ListNode temp = head;
            while (temp.next != toBeDeleted) {
                temp = temp.next;
            }
            // 删除该结点
            temp.next = null;
        }else {//在多个节点的情况下，如果删除的是某个中间结点
            //将下一个结点的值复制到当前待删除的结点
            toBeDeleted.value = toBeDeleted.next.value;
            //待删除的结点的下一个指向原先待删除引号的下下个结点，即将待删除的下一个结点删除
            toBeDeleted.next = toBeDeleted.next.next;
        }

        return head;
    }

    /**
     * 输出链表的元素值
     * @param head 链表的头结点
     */
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
        System.out.println("null");
    }
}
