package ArrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname NSumTarget
 * @Description 通用解法
 * @Author likui
 * @Date 2021/8/2 20:24
 **/
public class NSumTarget {
    /**
     * 调用方法前一定要先将数组排好序，避免在递归的时候每次都要进行排序，影响效率
     * @param nums
     * @param n twoSum就是2，threeSum就是3，fourSum就是4
     * @param start 起始位置
     * @param target 目标和
     * @return
     */
    public static List<List<Integer>> nSum(int[] nums, int n, int start, int target) {
        int size = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        //至少是2元组，且数值大小要大于n
        if (n < 2 || size < n)
            return res;
        List<Integer> list;
        //求二元组
        if (n == 2) {
            int low = start, high = size - 1;
            while (low < high) {
                int sum = nums[low] + nums[high];
                int left=nums[low],right=nums[high];
                if (sum < target) {
                    while (low < high && nums[low] == left)
                        low++;
                } else if (sum > target) {
                    while (low<high&&nums[high]==right)
                        high--;
                }else {
                    list=new ArrayList<>();
                    list.add(left);
                    list.add(right);
                    res.add(list);
                    //从左向右跳过重复部分
                    while (low<high&&nums[low]==left)
                        low++;
                    //从右向左
                    while (low<high&&nums[high]==right)
                        high--;
                }
            }
        }else {
            //穷举第一个数
            for(int i=start;i<size;i++) {
                //n>2时，递归计算(n-1)Sum的结果
                List<List<Integer>> tuples = nSum(nums, n - 1, i+1, target - nums[i]);
                for (List<Integer> tuple : tuples) {
                    //(n-1)sum+nums[i]就是nSum
                    tuple.add(nums[i]);
                    res.add(tuple);
                }
                //跳过和第一个数重复的数
                while (i<size-1&&nums[i]==nums[i+1])
                    i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //求target为0的三元组
        int[] nums=new int[]{1,0,-1,0,-2,2};
        //一定要先排序
        Arrays.sort(nums);
        nSum(nums,2,0,0).forEach(System.out::println);
    }
}
