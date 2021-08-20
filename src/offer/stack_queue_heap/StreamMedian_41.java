package offer.stack_queue_heap;

import java.util.PriorityQueue;

/**
 * @Classname StreamMedian_41
 * @Description 数据流中的中位数
 *              对于奇数个值，中位数就是所有数值排序之后位于中间的数值
 *              对于偶数个值，中位数就是所有数值排序之后位于中间的两个数的平均值
 * @Author likui
 * @Date 2021/7/1 22:45
 **/
public class StreamMedian_41 {
    //大顶堆，用于存储左边元素
    private PriorityQueue<Integer> left=new PriorityQueue<>((o1,o2)->o2-o1);

    //小顶堆，用于存储右边元素
    private PriorityQueue<Integer> right=new PriorityQueue<>();

    //当前数据流读入的元素个数
    private int N=0;

    /**
     * 用于插入数据
     * @param num
     */
    public void insert(Integer num) {
        //插入要保证两个堆处于平衡状态，
        //即两个堆中数据的数目之   差不能超过1，这样才能保证中位数是中间的数
        if(N%2==0){
            //如果N为偶数则插入到右边
            //右边的数大于左边，但是插入的数可能比左边的数要小，所以先将这个数插入到左边
            //利用左边大顶堆的特点，取出堆顶元素即最大元素，然后插入到右边，这样不管插入的数比左边大还是比左边小
            //都能保证插入右边后比左边的数大
            left.add(num);
            right.add(left.poll());
        }else {
            //与上面一样的道理
            //左边的数小于右边，但是插入的数可能比右边的数大
            right.add(num);
            left.add(right.poll());
        }
        N++;
    }

    /**
     * 获取中位数
     * @return
     */
    public Double getMedian() {
        if(N%2==0){
          return (left.peek()+right.peek())/2.0;
        }else {
            //因为第一个数是存放在右边的，如果这里获取的是left.peek就会抛出NPE异常
            return (double)right.peek();
        }
    }

    public static void main(String[] args) {
        StreamMedian_41 s=new StreamMedian_41();
        s.insert(5);
        System.out.println(s.getMedian());
        s.insert(2);
        System.out.println(s.getMedian());
        s.insert(3);
        System.out.println(s.getMedian());
        s.insert(4);
        System.out.println(s.getMedian());
        s.insert(1);
        System.out.println(s.getMedian());
        s.insert(6);
        System.out.println(s.getMedian());
        s.insert(7);
        System.out.println(s.getMedian());
        s.insert(0);
        System.out.println(s.getMedian());
        s.insert(8);
        System.out.println(s.getMedian());
    }
}
