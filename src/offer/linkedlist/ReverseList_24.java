package offer.linkedlist;

/**
 * @Classname ReverseList_24
 * @Description 反转链表
 * @Author likui
 * @Date 2021/7/6 21:25
 **/
public class ReverseList_24 {
    /**
     * 第一种解法：三指针，这里是三个节点
     *
     * @param pHead
     * @return
     */
    public ListNode reverseList(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        //由于单链表中只有指向下一个节点的指针
        //所以需要一个指针保存下一个节点的信息，同时需要一个一个前驱节点让当前节点指向它，达到反转
        ListNode pre = null;
        ListNode cur = pHead;
        ListNode next = null;
        while (cur != null) {
            //先当当前节点的下一个节点信息保存
            next = cur.next;
            //当前节点指向前驱节点
            cur.next = pre;
            //当前节点成为前驱节点
            pre = cur;
            //继续遍历
            cur = next;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode next = pHead.next;
        //先断开链表中原来节点的指向关系
        pHead.next = null;
        ListNode newHead = reverseList2(next);
        //重新改变节点的指向关系
        next.next = pHead;
        //因为是引用传递
        return newHead;
    }
}
