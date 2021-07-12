package offer.sort;

/**
 * @Classname InversePairs_51
 * @Description 数组中的逆序对。自用了暴力解法
 * @Author likui
 * @Date 2021/7/11 21:46
 **/
public class InversePairs_51 {
    int count=0;

    /**
     * 时间复杂度O(N^2)
     * 也可以使用一个两层for循环解决
     * @param nums
     * @return
     */
    public int inversePairs(int[] nums){
        if(nums==null||nums.length<=1)
            return 0;
        int i=0,j=1;
        int fast = helper(nums, i, j);
        while (fast==nums.length){
            i++;
            j=i+1;
            fast=helper(nums,i,j);
        }
        return count;
    }

    private int helper(int[] nums,int slow,int fast){
        while (fast<nums.length){
            if(nums[slow]>nums[fast]){
                count++;
                fast++;
            }else {
                fast++;
            }
        }
        return fast;
    }

    public static void main(String[] args) {
        InversePairs_51 i=new InversePairs_51();
        int[] nums={8};
        System.out.println(i.inversePairs(nums));
    }
}
