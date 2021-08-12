package LinkedList;

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
