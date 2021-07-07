package offer.linkedlist;

/**
 * @Classname FirstCommonNodesInLists_52
 * @Description 两个链表的第一个公共节点
 *              假设链表A的长度为a+c，链表B的长度为b+c，c为两个链表的公共部分
 *              因为是单链表，所以从第一个公共节点开始，后面的所有节点都是重合的
 *              并且有a+c+b=b+c+a，所以当访问链表A的指针到尾部时，让它从链表B开始访问
 *              当访问链表B的指针到尾部时，让它从链表A开始访问，这样就能保证访问A和B的指针能
 *              同时访问到公共节点
 * @Author likui
 * @Date 2021/7/7 23:43
 **/
public class FirstCommonNodesInLists_52 {
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1=pHead1;
        ListNode p2=pHead2;
        while (p1!=p2){
            //为什么这里判断的是==null而不是节点的next==null呢？
            //因为没有公共节点的时候返回的是null
            p1=(p1==null)?pHead2:p1.next;
            p2=(p2==null)?pHead1:p2.next;
        }
        return p1;
    }
}
