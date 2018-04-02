package sword.offer.tools;

/**
 * @Author:Zhangchaozhen
 * @Date: Create in 2018/4/2 14:17
 * @Description: 链表节点
 */
public class ListNode {
    public int value;
    public ListNode next;

    /**
     * 输出该节点之后的元素
     *
     * @param head 当前节点
     */
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("null");
    }
}
