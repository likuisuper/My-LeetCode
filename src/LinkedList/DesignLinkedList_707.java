package LinkedList;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

/*
设计链表

设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，
next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。
假设链表中的所有节点都是 0-index 的。

在链表类中实现这些功能：

get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。

示例：

MyLinkedList linkedList = new MyLinkedList();
linkedList.addAtHead(1);
linkedList.addAtTail(3);
linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
linkedList.get(1);            //返回2
linkedList.deleteAtIndex(1);  //现在链表是1-> 3
linkedList.get(1);            //返回3

提示：

所有val值都在 [1, 1000] 之内。
操作次数将在  [1, 1000] 之内。
请不要使用内置的 LinkedList 库。
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val=x;
    }
}
public class DesignLinkedList_707 {//一个文件只能有一个public修饰的类，且该类名字要和文件名一样
    int size;
    ListNode head;
    public DesignLinkedList_707(){
        size=0;
        head=new ListNode(0);
    }
    //通过索引获取元素值
    public int get(int index){
        if(index<0||index>=size)
            return -1;
        ListNode curr=head;
        for(int i=0;i<index+1;i++){
            curr=curr.next;
        }
        return curr.val;
    }
    //将元素添加到表头
    public void addAtHead(int val){
        addAtIndex(0,val);
    }
    //将元素添加到表尾
    public void addAtTail(int val){
        addAtIndex(size,val);
    }
    //添加元素
    public void addAtIndex(int index,int val){
        if(index>size)
            return;
        if(index<0)
            index=0;
        ++size;
        ListNode pre=head;
        for(int i=0;i<index;i++)
            pre=pre.next;
        ListNode newNode=new ListNode(val);
        newNode.next=pre.next;
        pre.next=newNode;
    }
    //删除元素
    public void deleteAtIndex(int index){
        if(index<0||index>=size)
            return;
        --size;
        ListNode pre=head;
        for(int i=0;i<index;i++)
            pre=pre.next;
        pre.next=pre.next.next;
    }

    public static void main(String[] args) {
        DesignLinkedList_707 design=new DesignLinkedList_707();
        design.addAtHead(1);
        design.addAtTail(3);
        design.addAtIndex(0,5);
        design.deleteAtIndex(1);
        int val=design.get(0);
        System.out.println(val);
    }
}
