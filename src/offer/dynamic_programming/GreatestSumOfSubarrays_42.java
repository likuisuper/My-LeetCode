package offer.dynamic_programming;

/**
 * @Classname GreatestSumOfSubarrays_42
 * @Description 连续子数组的最大和
 * @Author likui
 * @Date 2021/7/14 21:13
 **/
public class GreatestSumOfSubarrays_42 {
    /**
     * 动态规划解法
     * 1、明确dp数组的含义
     * 2、数组元素之间的关系式（状态转移方程）
     * 3、初始值
     * 时间复杂度和空间复杂度都是O(N)
     * @param nums
     * @return
     */
    public int findGreatestSumOfSubArray(int[] nums){
        int n=nums.length;
        if(n==0)
            return 0;
        //dp[i]的含义？以nums[i]结尾的连续子数组的最大和
        //数组长度为 1~n
        int[] dp=new int[n];
        //base case
        //第一个元素前面没有子数组
        dp[0]=nums[0];
        for (int i = 1; i < n; i++) {
            //状态就是连续子数组的和，它会一直变化
            //而让状态发生变化的就是选择，有2种选择
            //1、要么与前面的连续子数组相连，构成一个更大的连续子数组
            //2、要么不与前面的子数组相连，自成一派
            dp[i]=Math.max(nums[i],nums[i]+dp[i-1]);
        }

        //遍历dp数组，求出最大值
        //初始值不能是0，因为会出现多个负数相加的情况
        int result=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            Math.max(result,dp[i]);
        }
        return result;
    }

    /**
     * 因为dp[i]只和dp[i-1]有关，所以可以进行状态压缩
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     * @param nums
     * @return
     */
    public int findGreatestSumOfSubArray2(int[] nums){
        int n=nums.length;
        if(n==0)
            return 0;
        //base case
        int dp0=nums[0];
        int dp1=0;
        int result=dp0;
        for (int i = 1; i < n; i++) {
            //dp[i]=Math.max(nums[i],nums[i]+dp[i-1]
            dp1=Math.max(nums[i],nums[i]+dp0);
            dp0=dp1;
            //计算最大值
            result=Math.max(result,dp1);
        }
        return result;
    }
}
