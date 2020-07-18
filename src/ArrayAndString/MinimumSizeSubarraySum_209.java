package ArrayAndString;

/*
长度最小的子数组

给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。
如果不存在符合条件的连续子数组，返回 0。

示例:

输入: s = 7, nums = [2,3,1,2,4,3]
输出: 2
解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
进阶:

如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
public class MinimumSizeSubarraySum_209 {//滑动窗口，时间复杂度为O(n)
    public int minSubArrayLen(int s, int[] nums) {
        int n=nums.length;
        if(n==0)
            return 0;
        int left=0;
        int right=0;
        int sum=0;//子数组的和
        int min=Integer.MAX_VALUE;
        while(right<n){
            sum+=nums[right];
            right++;
            while (sum>=s){
                min=Math.min(min,right-left);//更新窗口最小值
                sum-=nums[left];
                left++;
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum_209 m=new MinimumSizeSubarraySum_209();
        System.out.println(m.minSubArrayLen(7,new int[]{2,3,1,2,4,2}));
    }
}
