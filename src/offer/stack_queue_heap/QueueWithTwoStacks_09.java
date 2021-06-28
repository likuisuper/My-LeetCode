package offer.stack_queue_heap;

import java.util.Stack;

/**
 * @Classname QueueWithTwoStacks_09
 * @Description 用两个栈实现队列
 * @Author likui
 * @Date 2021/6/28 23:41
 **/
public class QueueWithTwoStacks_09 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() throws Exception {
        //栈2为空，并且栈1不为空，将栈1元素出队并且压入栈2
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            throw new Exception("queue is empty!");
        }

        return stack2.pop();
    }
}
