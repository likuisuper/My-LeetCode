package offer.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname KthNodeFromEnd_22
 * @Description 链表中倒数第K个节点
 * @Author likui
 * @Date 2021/7/5 20:37
 **/
public class KthNodeFromEnd_22 {
    public ListNode findKthToTail(ListNode pHead, int k) {
        /**
         * 需要两次遍历链表，时间复杂度为O(N)
         */
        if (pHead == null || k == 0)
            return null;
        //第一次遍历链表，得到链表的长度
        int count = 0;
        ListNode node = pHead;
        //不能根据node.next来判断，比如[1],1这个测试用例就过不了，下面的1>0，直接返回Null了
        while (node!= null) {
            node = node.next;
            count++;
        }
        //如果K大于链表长度，返回长度为0的链表
        if (k > count) {
            return null;
        }
        //第二次遍历链表，找到第K个节点的位置
        for (int i = 1; i <= count; i++) {
            //倒数第K个节点的位置=链表长度-K+1，加1是因为下标从0开始
            if (i == count - k + 1)
                return pHead;
            pHead = pHead.next;
        }
        return null;
    }

    public ListNode findKthToTail2(ListNode pHead, int k) {
        if(pHead==null||k==0)
            return null;
        //声明两个指针
        ListNode p1=pHead;
        //让p1和p2保持k-1的距离，这样当p1指向尾结点时，p2刚好是倒数第k个节点
//        for (int i = 0; i < k - 1; i++) {
//            //p1指针开始向前走K-1步
//            //防止K>链表的情况
//            if(p1.next!=null) {
//                p1 = p1.next;
//            }else {
//                return null;
//            }
//
//        }
//        //p2指向首节点
//        ListNode p2=pHead;
//        while (p1.next!=null){
//            //从第K步开始，让p1，p2一起向前走
//            p1=p1.next;
//            p2=p2.next;
//        }
//        return p2;



        while (p1 != null && k-- > 0)
            p1 = p1.next;
        if (k > 0)
            return null;
        //p2指向首节点
        ListNode p2=pHead;
        while (p1!=null){
            //从第K步开始，让p1，p2一起向前走
            p1=p1.next;
            p2=p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        Set<Integer> set=new HashSet<>();
        set.add(1);
        set.add(1);
        System.out.println(set);
    }

}
