package offer.linkedlist;

/**
 * @Classname CopyComplexList_35
 * @Description 复杂链表的复制
 * @Author likui
 * @Date 2021/7/7 21:13
 **/
public class CopyComplexList_35 {
    public RandomListNode clone(RandomListNode pHead) {
        if(pHead==null||pHead.next==null){
            return pHead;
        }
        //1、复制原来节点
        RandomListNode cur=pHead;
        while (cur!=null){
            //类似头插法
            RandomListNode clone=new RandomListNode(cur.label);
            clone.next=cur.next;
            cur.next=clone;
            clone.random=null;
            //这里注意是clone.next，跳过刚才复制的节点
            cur=clone.next;
        }
        //2、复制随机节点
        //让cur重新指向头节点
        cur=pHead;
        while (cur!=null){
            RandomListNode clone = cur.next;
            if(cur.random!=null){
                //clone节点的random就是原节点的random的next
                clone.random=cur.random.next;
            }
            cur=clone.next;
        }
        //3、拆分，将链表上的原节点和复制节点分开
        //让cur重新指向头节点
        cur=pHead;
        //返回拆分后的复制链表，即当前链表节点的下一个节点
        //因为pHead会随着cur的变化而变化，所以将头节点的下一个节点也就是复制节点保存
        //后面的操作会将后续的复制节点链接到该节点所在的链表，然后直接返回该链表
        RandomListNode pCloneHead=pHead.next;
        while (cur.next!=null){
            //保存当前节点的下一个节点
            RandomListNode next = cur.next;
            //当前节点指向下一个节点的下一个节点
            cur.next=next.next;
            //当前节点向后遍历
            cur=next;
        }
        return pCloneHead;
    }
}


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
