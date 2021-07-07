package offer.linkedlist;

/**
 * @Classname MergeSortedLists_25
 * @Description 合并两个排序的链表，合并后的链表仍然有序
 * @Author likui
 * @Date 2021/7/6 22:55
 **/
public class MergeSortedLists_25 {
    /**
     * 第一种解法：递归
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode merge1(ListNode list1, ListNode list2) {
        //递归出口
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            //说明list1是头节点
            list1.next = merge1(list1.next, list2);
            return list1;
        } else {
            //否则list2是头节点
            list2.next = merge1(list2.next, list1);
            return list2;
        }
    }

    /**
     * 使用迭代的方式
     * 时间复杂度O(M+N)，M和N是两个链表的长度
     * 空间复杂度O(1)，节点引用pHead和cur使用常数大小的额外空间
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode merge2(ListNode list1, ListNode list2) {
        //先构建一个头节点，即辅助节点
        ListNode pHead = new ListNode(-1);
        //cur是不断向后遍历的节点
        ListNode cur = pHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                //说明此时list1是第一个节点
                //此时pHead指向的也是list1
                cur.next = list1;
                //list1向后遍历
                list1 = list1.next;
            } else {
                //说明此时list2是第一个节点
                cur.next = list2;
                list2 = list2.next;
            }
            //让cur也向后遍历
            //这里需要注意，上面的cur.next指向的值也是pHead指向的值，
            //但是在这里，cur已经指向了下一个节点，而pHead还是指向list1或list2
            //然后通过cur.next不断将节点加到第一个节点后
            cur = cur.next;
        }
        //上面while循环结束后，会出现list1为null或者list2为null的情况
        //所以要让合并后的链表继续链接是上其中一个不为空的链表节点
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        //这里返回的是pHead.next，因为上面说过pHead.next指向的就是合并链表后的第一个节点
        return pHead.next;
    }

}
