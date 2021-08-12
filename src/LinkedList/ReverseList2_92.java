package LinkedList;

/**
 * @Classname ReverseList2_92
 * @Description 反转链表的一部分
 * @Author likui
 * @Date 2021/8/11 22:06
 **/
public class ReverseList2_92 {
    //保存后继节点
    ListNode successor=null;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==1){
            //left为1，就是反转链表的前n个节点
            return reverseBefore(head,right);
        }
        //让head.next指向后面已经反转好的部分链表
        //因为是部分反转，所以不能是head.next.next=...
        //把head的节点的索引视为1，那么是反转第m个节点，如果把head.next的索引视为1，那么就是反转第m-1个节点，以此类推
        head.next=reverseBetween(head.next,left-1,right-1);
        return head;
    }

    /**
     * 反转链表的前N个节点
     * @param head
     * @param n
     * @return
     */
    private ListNode reverseBefore(ListNode head,int n){
        if(n==1){
            //记录第n+1个节点
            successor=head.next;
            return head;
        }
        ListNode node= reverseBefore(head.next,n-1);
        head.next.next=head;
        //不再指向null，而是指向第n+1个节点
        head.next=successor;
        return node;
    }
}
