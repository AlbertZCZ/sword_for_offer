package sword.offer;

import java.util.Stack;

/**
 * @Author:Zhangchaozhen
 * @Date: Create in 2018/4/4 21:07
 * @Description: 输入两个整数序列，第一个序列表示栈的压入顺序，请判断二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1 、2、3 、4、5 是某栈压栈序列，
 * 序列4、5、3、2、1是该压栈序列对应的一个弹出序列，
 * 但4、3、5、1、2就不可能是该压棋序列的弹出序列。
 */
public class Interview22 {
    /**
     *
     * @param push 入栈序列
     * @param pop 出栈序列
     * @return true：出栈序列是入栈序列的一个弹出顺序
     */
    public static boolean isPopOrder(int[] push, int[] pop) {
        if (push == null || pop == null || pop.length == 0 || push.length == 0 || pop.length != push.length) {
            return false;
        }

        // 经过上面的参数校验，两个数组中一定有数据，且数据数目相等

        // 用于存放入栈时的数据
        Stack<Integer> stack = new Stack<>();
        // 用于记录入栈数组元素的处理位置
        int pushIndex = 0;
        // 用于记录出栈数组元素的处理位置
        int popIndex = 0;
        // 如果还有出栈元素要处理
        while (popIndex < pop.length) {
            // 入栈元素还未全部入栈的条件下，如果栈为空，或者栈顶的元素不与当前处理的相等，则一直进行栈操作，
            // 直到入栈元素全部入栈或者找到了一个与当出栈元素相等的元素
            while (pushIndex  < push.length && (stack.isEmpty() || stack.peek() != push[pushIndex])) {
                // 入栈数组中的元素入栈
                stack.push(push[pushIndex]);
                // 指向下一个要处理的入栈元素
                pushIndex++;
            }
            if (stack.peek() == push[pushIndex]) {
                // 将元素出栈
                stack.pop();
                // 处理下一个出栈元素
                popIndex++;
            }else {
                // 如果没有找到与出栈元素相等的元素，说明这个出栈顺序是不合法的
                // 就返回false
                return false;
            }

        }
        // 下面的语句总是成立的
        // return stack.isEmpty();

        // 为什么可以直接返回true：对上面的外层while进行分析可知道，对每一个入栈的元素，
        // 在stack栈中，通过一些入栈操作，总可以在栈顶上找到与入栈元素值相同的元素，
        // 这就说明了这个出栈的顺序是入栈顺序的一个弹出队列，这也可以解释为什么stack.isEmpty()
        // 总是返回true，所有的入栈元素都可以进栈，并且可以被匹配到，之后就弹出，最后栈中就无元素。
        return true;
    }
}
