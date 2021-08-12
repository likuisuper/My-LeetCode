package LinkedList;

/**
 * @Classname ReverseNodesInKGroup_25
 * @Description k个一组反转翻转链表。
 * @Author likui
 * @Date 2021/8/12 22:08
 **/
public class ReverseNodesInKGroup_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)
            return head;
        //反转区间[a,b)的节点
        ListNode a,b;
        a=b=head;
        for(int i=0;i<k;i++){
            //不足k个，返回head，即剩余的节点不需要反转
            if(b==null)
                return head;
            b=b.next;
        }
        //反转a到b之间的节点，即前k个节点
        ListNode node=reverse(a,b);
        //继续反转后续节点，并且将前面的k个节点和后面的K个节点相连
        //就是左图中1指向后面k个节点
        a.next=reverseKGroup(b,k);
        return node;
    }

    /**
     * 反转链表可以理解为反转以head为头节点到null之间的节点
     * 所以反转head节点到b节点之间的节点，把原来为null的地方替换成b即可
     * @param a
     * @param b
     * @return
     */
    private ListNode reverse(ListNode a,ListNode b){
        //[a,b)，取不到b的
        if(a==b||a.next==b)
            return a;
        //相当于把a节点的地址赋值给了node
        //然后node的值每次就是下面函数的返回值，但是a是一直在变化的
        ListNode node=reverse(a.next,b);
        a.next.next=a;
        a.next=b;
        return node;
    }
}
