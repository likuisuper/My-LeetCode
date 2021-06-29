package offer.stack_queue_heap;

import java.util.Stack;

/**
 * @Classname StackPushPopOrder_31
 * @Description 栈的压入，弹出序列
 * @Author likui
 * @Date 2021/6/29 23:05
 **/
public class StackPushPopOrder_31 {
    public boolean IsPopOrder(int[] pushSequence, int[] popSequence){
        Stack<Integer> stack=new Stack<>();
        int n=pushSequence.length;
        for (int pushIndex = 0,popIndex=0; pushIndex < n; pushIndex++) {
            //弹出序列中的元素不在栈顶，继续将压栈序列压入栈
            stack.push(pushSequence[pushIndex]);
            //如果当前栈的栈顶元素等于弹出序列的第一个元素
            while (popIndex<n&&!stack.isEmpty()&&stack.peek()==popSequence[popIndex]){
                //出栈
                stack.pop();
                //将弹出序列往后移
                popIndex++;
            }
        }
        //如果栈为空，说明所有元素都已弹出，返回true
        //否则说明还有元素没有弹出，那么该序列不可能是一个弹出序列
        return stack.isEmpty();
    }
}
