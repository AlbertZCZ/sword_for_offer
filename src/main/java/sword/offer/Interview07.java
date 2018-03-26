package sword.offer;

import java.util.Stack;

/**
 * @Author:Zhangchaozhen
 * @Date: Create in 2018/3/26 18:03
 * @Description: 用两个栈模拟的队列
 * 用两个核实现一个队列。队列的声明如下，诸实现它的两个函数appendTail和deleteHead，
 * 分别完成在队列尾部插入结点和在队列头部删除结点的功能。
 */
public class Interview07 {
    public static class MList<T> {
        // 插入栈，只用于插入的数据
        private Stack<T> stackPut = new Stack<T>();
        // 弹出栈，只用于弹出数据
        private Stack<T> stackDel = new Stack<T>();

        public MList() {}

        // 添加操作，成在队列尾部插入结点
        public T appendTail(T t) {
            stackPut.push(t);
            return t;
        }

        // 删除操作，在队列头部删除结点
        public T deleteHead() {
            // 如果弹出栈中还没有数据就抛出异常
            if (stackPut.isEmpty() && stackDel.isEmpty())
                throw new RuntimeException("No more element.");
            // 先判断弹出栈是否为空，如果为空就将插入栈的所有数据弹出栈，
            // 并且将弹出的数据压入弹出栈中
            if (stackDel.isEmpty()) {
                while (!stackPut.isEmpty()) {
                    stackDel.push(stackPut.pop());
                }
            }
            return stackDel.pop();
        }
    }
}
