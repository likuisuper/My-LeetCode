package offer.linkedlist;

/**
 * @Classname DeleteNodeInList_18_01
 * @Description 在O(1)时间内删除链表节点，但力扣上的题目和剑指上有修改，所以这里实现的是O(N)
 * @Author likui
 * @Date 2021/7/4 20:53
 **/
public class DeleteNodeInList_18_01 {
    public ListNode deleteNode(ListNode node,int val){
        if(node==null){
            return null;
        }
        //如果第一个节点就是要删除的节点
        if(node.val==val){
            //直接删除
            return node.next;
        }
        //声明一个pre指针指向当前节点的前一个节点，cur指针指向当前节点
        ListNode pre=node;
        ListNode cur=node.next;
        //只要当前节点不为空，并且当前节点值不等于要删除的节点
        while (cur!=null&&cur.val!=val){
            //将pre往后移
            pre=cur;
            //向后遍历
            cur=cur.next;
        }
        if(cur!=null){
            //
            pre.next=cur.next;
        }
        return node;
    }
}
