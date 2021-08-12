package LinkedList;

/**
 * @Classname MiddleOfTheLinkedList_876
 * @Description 链表的中点。寻找链表的中点的一个重要作用是对链表进行归并排序
 * @Author likui
 * @Date 2021/8/11 20:54
 **/
public class MiddleOfTheLinkedList_876 {
    public ListNode middleNode(ListNode head) {
        ListNode fast,slow;
        fast=slow=head;
        //当快指针到达链表尾部时，慢指针刚好处于链表中间位置
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
