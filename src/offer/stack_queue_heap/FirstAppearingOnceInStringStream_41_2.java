package offer.stack_queue_heap;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname FirstAppearingOnceInStringStream_41_2
 * @Description 字符流中第一个不重复的字符
 * @Author likui
 * @Date 2021/7/1 23:21
 **/
public class FirstAppearingOnceInStringStream_41_2 {
    //出现字符，就要想到ASCII码，有128位
    //只出现一次，说明涉及重复问题，那么需要一个容器来保存出现的次数
    private int[] cnts=new int[128];

    //涉及顺序问题（第一个），应该想到队列
    private Queue<Character> queue=new LinkedList<>();

    public void insert(char ch){
        //记录字符次数
        cnts[ch]++;
        queue.add(ch);
        //如果对头元素出现的次数大于1，那么将它从队列移除
        while (!queue.isEmpty()&&cnts[queue.peek()]>1){
            queue.poll();
        }
    }
    //return the first appearence once char in current stringstream
    public char firstAppearingOnce(){
        //如果找不到这样的字符，那么返回#
        return queue.isEmpty()?'#':queue.peek();
    }

    public static void main(String[] args) {
        FirstAppearingOnceInStringStream_41_2 first=new FirstAppearingOnceInStringStream_41_2();
        first.insert('g');
        System.out.println(first.firstAppearingOnce());
        first.insert('o');
        System.out.println(first.firstAppearingOnce());
        first.insert('o');
        System.out.println(first.firstAppearingOnce());
        first.insert('g');
        System.out.println(first.firstAppearingOnce());
        first.insert('l');
        System.out.println(first.firstAppearingOnce());
        first.insert('e');
        System.out.println(first.firstAppearingOnce());
    }
}
