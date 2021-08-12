package offer.linkedlist;

/**
 * @Classname EntryNodeOfLoop_23
 * @Description 链表中环的入口节点   三个步骤：
 *              1、判断链表是否有环，使用快慢指针
 *              2、判断链表中环的节点个数
 *              3、找到环的入口节点
 *              两个测试用例：{1,2,3},{4,5,6,7}和{},{1,2,3,4,5}
 * @Author likui
 * @Date 2021/7/6 10:05
 **/
public class EntryNodeOfLoop_23 {
    /**
     * 第一种解法：使用3个步骤
     * @param pHead
     * @return
     */
    public ListNode entryNodeOfLoop(ListNode pHead){
        if(pHead==null||pHead.next==null){
            return null;
        }
        //两个快慢指针，刚开始时两者间隔1个节点，后移移动间隔2个节点
        ListNode slow=pHead;
        ListNode fast=pHead;
        //是否存在环的标记
        boolean flag=false;
        //1、判断链表是否存在环
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            //如果两者相遇，说明存在环
            if(slow==fast){
                flag=true;
                break;
            }
        }
        //如果不存在环直接返回null
        if(!flag){
            return null;
        }else {
            //2、得到环中节点个数,用n表示
            int n=1;
            fast=fast.next;
            while (slow!=fast){
                fast=fast.next;
                n++;
            }
            //找到环中入口节点
            //让slow,fast重新从头节点开始
            slow=pHead;
            fast=pHead;
            for (int i = 0; i < n; i++) {
                fast=fast.next;
            }
            //两者相遇处即为环的入口节点
            while (slow!=fast){
                slow=slow.next;
                fast=fast.next;
            }
            return slow;
        }
    }

    /**
     * 第二种解法，不用求出环中节点个数
     * @param pHead
     * @return
     */
    public ListNode entryNodeOfLoop2(ListNode head){
        if(head==null||head.next==null)
            return null;
        ListNode fast,slow;
        fast=slow=head;
        while(true){
            //防止只有一个节点的情况
            if(fast==null||fast.next==null)
                return null;
            fast=fast.next.next;
            slow=slow.next;
            //说明存在环
            if(fast==slow)
                break;
        }
        //让slow重新从头节点开始遍历
        slow=head;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
