package offer.stack_queue_heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Classname KLeastNumbers_40
 * @Description 最小的K个数
 * @Author likui
 * @Date 2021/6/30 21:43
 **/
public class KLeastNumbers_40 {
    /**
     * 第一种方式是使用大顶堆实现（小顶堆的话需要将所有元素都插入堆，然后取最小的k个元素，大顶堆只需要维护前k个最小值）
     * 时间复杂度为：O(NlogK)，最坏情况下，k=nums.length，那么会将n个数都插入堆
     * 空间复杂度：O(K)
     *
     * 如果要求第k个最大的数呢？使用小顶堆，最后返回堆顶元素即可
     * @param nums
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k){
        if(nums==null||k>nums.length||k<0){
            return new ArrayList<>();
        }
        //默认的是小顶堆，所以需要自定义排序实现大顶堆
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int num : nums) {
            //维护堆的大小为k
            maxHeap.add(num);
            if(maxHeap.size()>k){
                //大小大于k便出队
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);
    }

    /**
     * 基于快速排序。复杂度：O(N)+O(1)，只有当允许修改数组元素时才可以使用
     * 快速排序的 partition() 方法，会返回一个整数 j 使得 a[l..j-1] 小于等于 a[j]，且 a[j+1..h] 大于等于 a[j]，此时 a[j] 就是数组的第 j 大元素（数组下标，所以应该是j+1）。
     * 可以利用这个特性找出数组的第 K 个元素，这种找第 K 个元素的算法称为快速选择算法。
     * @param nums
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] nums, int k){
        ArrayList<Integer> list=new ArrayList<>();
        if(nums==null||k>nums.length||k<0){
            return list;
        }
        //注意这里传入的k-1，因为要和下标比较
        findKthSmallest(nums,k-1);
        //findKthSmallest会改变数组，使得前k个数都是最小的k个数
        for (int i = 0; i < k; i++) {
            list.add(nums[i]);
        }
        return list;
    }

    private void findKthSmallest(int[] nums,int k){
        int l=0,h=nums.length-1;
        while (l<h){
            int pos=partition(nums,l,h);
            //nums[pos]就是数组第pos大元素
            if(pos==k)
                break;
            //最小的k个数还要往前找
            if(pos>k)
                h=pos-1;
            //最小的k个数还要往后找
            else
                l=pos+1;
        }
    }

    private int partition(int[] nums, int l, int h) {
        int i=l;
        //j=h+1是因为while循环中会先执行--操作
        int j=h+1;
        //取第一个为基准元素pivot
        int val=nums[l];
        while (true){
            //保证nums[l..i]都小于pivot
            while (i != h && nums[++i] < val) ;
            //保证nums[j..h]都大于pivot
            while (j != l && nums[--j] > val) ;
            if (i >= j)
                break;
            //如果走到这里一定有nums[i]>pivot&&nums[j]<pivot
            //所以需要交换nums[i]和nums[j]
            //保证nums[l..i]<pivot<nums[j..h]
            nums[i]=nums[j]^(nums[j]=nums[i])^nums[i];
        }
        //循环结束将基准元素pivot交换到正确的位置
        nums[l]=nums[j]^(nums[j]=nums[l])^nums[l];
        return j;
    }


    public static void main(String[] args) {
        System.out.println(new KLeastNumbers_40().GetLeastNumbers_Solution2(new int[]{5,4,6,2,3}, 3));
    }
}
