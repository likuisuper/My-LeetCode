package offer.linkedlist;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Classname PrintListInReversedOrder_06
 * @Description 从尾到头打印链表
 * @Author likui
 * @Date 2021/7/3 23:44
 **/
public class PrintListInReversedOrder_06 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack=new Stack<>();
        while (listNode!=null){
            stack.add(listNode.val);
            listNode=listNode.next;
        }
        ArrayList<Integer> list=new ArrayList<>();
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode){
        ArrayList<Integer> list=new ArrayList<>();
        if (listNode!=null){
            //要先把下一个节点返回的集合添加到当前集合中，不然会丢失节点值
            list.addAll(printListFromTailToHead2(listNode.next));
            //添加节点值
            list.add(listNode.val);
        }
        return list;
    }
}
