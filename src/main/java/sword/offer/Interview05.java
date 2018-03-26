package sword.offer;

import java.util.Stack;

/**
 * @Author:Zhangchaozhen
 * @Date: Create in 2018/3/26 10:41
 * @Description: 输入一个链表头结点，从尾到头打印每个结点
 */
public class Interview05 {
    static class Node {
        public int value;
        public Node next;

        public Node(int value,Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 栈实现反向打印链表
     * @param head
     */
    public static void printReversingly(Node head) {
        //非空检查
        if (head == null) {
            System.out.println("空");
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        Node temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().value);
        }
    }
}
