package offer.linkedlist;

/**
 * @Classname ListNode
 * @Description 链表节点
 * @Author likui
 * @Date 2021/7/3 23:45
 **/
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ListNode{");
        sb.append("val=").append(val);
        sb.append(", next=").append(next);
        sb.append('}');
        return sb.toString();
    }
}
