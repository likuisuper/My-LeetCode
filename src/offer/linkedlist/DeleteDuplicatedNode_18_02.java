package offer.linkedlist;

/**
 * @Classname DeleteDuplicatedNode_18_02
 * @Description 删除一个排序列表中重复的节点
 * @Author likui
 * @Date 2021/7/4 22:52
 **/
public class DeleteDuplicatedNode_18_02 {
    public ListNode deleteDuplicatedNode(ListNode pHead){
        //递归退出条件
        if(pHead==null||pHead.next==null)
            return pHead;
        ListNode next=pHead.next;
        //如果节点值重复
        if(pHead.val==next.val){
            //只要节点重复，继续遍历下一个节点
            while (next!=null&&pHead.val==next.val){
                next=next.next;
            }
            //循环结束，说明该节点已经不是重复节点，递归的目的是找到返回值，让前面不重复的节点指向该节点
            return deleteDuplicatedNode(next);
        }else {
           //节点不重复，让当前节点指向下一个不重复的节点
            pHead.next=deleteDuplicatedNode(pHead.next);
            return pHead;
        }
    }
}
