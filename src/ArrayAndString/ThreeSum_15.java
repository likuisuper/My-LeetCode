package ArrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname ThreeSum_15
 * @Description 三数之和
 *              给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 *              请你找出所有和为 0 且不重复的三元组。
 *              注意：答案中不可以包含重复的三元组。
 *              输入：nums = [-1,0,1,2,-1,-4]
 *              输出：[[-1,-1,2],[-1,0,1]]
 * @Author likui
 * @Date 2021/8/1 22:56
 **/
public class ThreeSum_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        //这里输入0即可
        return threeSumTarget(nums,0,0);
    }

    /**
     * 将题目泛化成计算和为target的三元组
     * 第一个数字可能是nums中的每一个数nums[i]
     * 剩下的两个数就是target-nums[i]，也就是twoSum要解决的的问题
     * 时间复杂度O(NlogN+N^2)=O(N^2)
     * @param nums
     * @param start 为了能让fourSum能够复用
     * @param target
     * @return
     */
    public static List<List<Integer>> threeSumTarget(int[] nums,int start,int target){
        //先对数组排序
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        //穷举threeSum的第一个数
        for (int i = start; i < n; i++) {
            //对target-nums[i]计算二元组
            List<List<Integer>> tuples = TwoSumTarget.twoSum(nums, i + 1, target - nums[i]);
            for (List<Integer> tuple : tuples) {
                //将第一个数加入二元组中，组成三元组
                tuple.add(nums[i]);
                res.add(tuple);
            }
            //避免重复，主要是避免第一个数重复，后面两个数在twoSum中已经保证不会重复了
            while (i<n-1&&nums[i]==nums[i+1])
                i++;
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum_15 threeSum_15=new ThreeSum_15();
//        threeSum_15.threeSum(new int[]{1,1,1,2,3}).forEach(System.out::println);
        threeSum_15.threeSum(new int[]{-1,0,1,2,-1,-4}).forEach(System.out::println);
    }
}
