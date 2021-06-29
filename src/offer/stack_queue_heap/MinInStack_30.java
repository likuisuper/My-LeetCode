package offer.stack_queue_heap;

import java.util.Stack;

/**
 * @Classname MinInStack_30
 * @Description 包含min函数的栈
 * @Author likui
 * @Date 2021/6/29 20:53
 **/
public class MinInStack_30 {
    //数据栈
    Stack<Integer> dataStack=new Stack<>();
    //辅助栈
    Stack<Integer> minStack=new Stack<>();

    int min=0;

    public void push(int node){
        dataStack.push(node);
        //比较入栈元素和当前栈中最小值，将值较小的push到minStack中
        //保证minStack的栈顶一直是最小元素
        minStack.push(minStack.isEmpty()?node:Math.min(minStack.peek(),node));
    }

    public void pop(){
        //两个都需要pop
        dataStack.pop();
        minStack.pop();
    }

    public void top(){
        dataStack.peek();
    }

    public int min(){
        return minStack.peek();
    }
}
