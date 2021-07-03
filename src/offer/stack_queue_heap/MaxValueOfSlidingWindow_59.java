package offer.stack_queue_heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @Classname MaxValueOfSlidingWindow_59
 * @Description 滑动窗口的最大值。涉及最大最小，首先应想到堆，滑动窗口的问题就是双指针的升级
 * @Author likui
 * @Date 2021/7/2 21:03
 **/
public class MaxValueOfSlidingWindow_59 {
    /**
     * 堆中删除和插入时间复杂度都是logM，因此该算法的时间复杂度为NLogM（最坏情况下窗口大小为数组长度），空间复杂度为O(M)
     * @param num 给定的数组，假设长度为N
     * @param size 滑动窗口的大小，假设为M
     * @return
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list=new ArrayList<>();
        if(num==null||num.length==0||size>num.length||size<1){
            return list;
        }
        //维护一个大顶堆
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((o1,o2)->o2-o1);
        for (int i = 0; i < size; i++) {
            //堆的大小为滑动窗口的大小
            maxHeap.add(num[i]);
        }
        //首先先将第一个窗口的最大值放入list中
        list.add(maxHeap.peek());
        //滑动
        for(int i=0,j=i+size;j<num.length;i++,j++){
            //先在堆中删除离开窗口的元素
            maxHeap.remove(num[i]);
            //将新的元素加入窗口
            maxHeap.add(num[j]);
            list.add(maxHeap.peek());
        }
        return list;
    }

    public static void main(String[] args) {
        MaxValueOfSlidingWindow_59 m=new MaxValueOfSlidingWindow_59();
        int[] nums={2,3,3,2,6,2,6,1};
        System.out.println(m.maxInWindows(nums, 8));
    }
}
