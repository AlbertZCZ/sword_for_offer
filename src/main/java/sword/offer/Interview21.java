package sword.offer;

import java.util.Stack;

/**
 * @Author:Zhangchaozhen
 * @Date: Create in 2018/4/4 19:58
 * @Description: 定义栈的数据结构，请在该类型中实现一个能够得到校的最小元素的min函数。
 * 在该栈中，调用pop、push 及min的时间复杂度都是0(1)
 */
public class Interview21 {
    /**
     * 采用辅助栈记录每次入栈后的最小元素
     * @param <T> 泛型参数
     */
    public static class StackWithMin<T extends Comparable<T>> {
        //数据栈用于存放元素
        private Stack<T> dataStack;
        //最小数辅助栈，存放数据栈中最小数的位置
        private Stack<T> minStack;

        public StackWithMin() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
        }

        /**
         * 出栈方法
         * @return
         */
        public T pop() {
            if (dataStack.isEmpty())
                throw new RuntimeException("栈中无数据");
            minStack.pop();
            return dataStack.pop();
        }

        /**
         * 入栈方法
         * @param t 入栈元素
         */
        public void push(T t) {
            if (t == null)
                throw new RuntimeException("入栈元素为空");
            // 如果数据栈是空的，只接将元素入栈，同时更新最小数栈中的数据
            if (dataStack.isEmpty()) {
                dataStack.push(t);
                minStack.push(t);
            }else {
                //获取当前最小元素
                T e = minStack.peek();
                //将t入栈
                dataStack.push(t);
                // 如果插入的数据比栈中的最小元素小
                if (t.compareTo(e) < 0)
                    // 将新的最小元素的位置入最小栈
                    minStack.push(t);
                else
                    //复制最小栈栈顶元素，将其入栈
                    minStack.push(e);

            }
        }

        /**
         * 获取栈中最小元素
         * @return 最小元素
         */
        public T min() {
            // 如果最小数公位置栈已经为空（数据栈中已经没有数据了），则抛出异常
            if (minStack.isEmpty()) {
                throw new RuntimeException("No element in stack.");
            }
            // 获取数据栈中的最小元素，并且返回结果
            return minStack.peek();
        }
    }
}
