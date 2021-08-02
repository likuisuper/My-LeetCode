package ArrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname FourSum_18
 * @Description 四数之和
 *              给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 *              判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
 *              找出所有满足条件且不重复的四元组。
 *
 *              注意：答案中不可以包含重复的四元组。
 *              示例
 *              输入：nums = [1,0,-1,0,-2,2], target = 0
 *              输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * @Author likui
 * @Date 2021/8/1 23:41
 **/
public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return fourSumTarget(nums,target);
    }

    /**
     * 第一个数字可能是nums中的每一个数nums[i]
     * 剩下的三个数就是target-nums[i]，也就是threeSum要解决的的问题
     * 时间复杂度O(NlogN+N^3)=O(N^3)
     * @param nums
     * @param target
     * @return
     */
    private List<List<Integer>> fourSumTarget(int[] nums,int target){
        //先对数组排序
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        //穷举fourSum的第一个数
        for (int i = 0; i < n; i++) {
            //对target-nums[i]计算三元组
            List<List<Integer>> tuples = ThreeSum_15.threeSumTarget(nums, i + 1, target - nums[i]);
            for (List<Integer> tuple : tuples) {
                //将第一个数加入三元组中，组成四元组
                tuple.add(nums[i]);
                res.add(tuple);
            }
            //避免重复，主要是避免第一个数重复，后面三个数在twoSum中已经保证不会重复了
            while (i<n-1&&nums[i]==nums[i+1])
                i++;
        }
        return res;
    }

    public static void main(String[] args) {
        FourSum_18 sum_18=new FourSum_18();
        sum_18.fourSum(new int[]{1,0,-1,0,-2,2},0);
    }
}
