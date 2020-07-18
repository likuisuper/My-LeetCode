package ArrayAndString;

import java.util.Arrays;

/*
两数之和 II - 输入有序数组

给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

说明:

返回的下标值（index1 和 index2）不是从零开始的。
你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
示例:

输入: numbers = [2, 7, 11, 15], target = 9
输出: [1,2]
解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class TwoSum2_167 {
    /*
    思路就是双指针，i不动，让j--，或者j不动，i++
     */

    /*下面这个方面时间复杂度高，但是空间复杂度为O(1)
    public int[] twoSum(int[] nums,int target){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target)
                    return new int[]{i+1,j+1};
            }
        }
        return new int[]{0,0};
    }
     */


    public int[] twoSum(int[] nums,int target){
        int low=0,hight=nums.length-1;
        while(low<hight){
            int sum=nums[low]+nums[hight];
            if(sum==target)
                return new int[]{low+1,hight+1};
            else if(sum>target)
                hight--;
            else
                low++;
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        TwoSum2_167 t=new TwoSum2_167();
        System.out.println(Arrays.toString(t.twoSum(new int[]{2,7,11,15},28)));
    }
}
