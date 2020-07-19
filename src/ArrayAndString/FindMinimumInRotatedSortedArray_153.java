package ArrayAndString;

/**
寻找旋转排序数组中的最小值

假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

请找出其中最小的元素。

你可以假设数组中不存在重复元素。

示例 1:

输入: [3,4,5,1,2]
输出: 1
示例 2:

输入: [4,5,6,7,0,1,2]
输出: 0
 */
public class FindMinimumInRotatedSortedArray_153 {
    /*方法一：暴力搜索，时间复杂度为O(n)
    public int finMin(int[] nums){
        int min=nums[0];
        for(int i=1;i<nums.length;++i){
            if(nums[i]<min)
                min=nums[i];
        }
        return min;
    }
     */

    //方法二：改进的二分搜索,复杂度为logN
    public int finMin(int[] nums){
        if(nums.length==1)
            return nums[0];//返回第一个元素
        int left=0,right=nums.length-1;
        //如果该数组没有被旋转，则返回第一个元素
        if(nums[right]>nums[0])
            return nums[0];
        //改进过的二分搜索(寻找变化点),因为不再是有序数组
        //所有变化点左侧元素>数组第一个元素，所有变化点右侧元素<数组第一个元素
        while(right>=left){
            //找到中间元素
            int mid=left+(right-left)/2;//要加上left，因为后面要从left开始
            if(nums[mid]>nums[mid+1])
                return nums[mid+1];
            if(nums[mid-1]>nums[mid])
                return nums[mid];
            if(nums[mid]>nums[0]){//说明此时左边是有序的，要在右边寻找变化点,如数组4,5,6,7,2,3
                left=mid+1;
            }
            else{//说明此时右边是有序的，要在左边寻找变化点，如数组5,1,2,3,4
                right=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray_153 find=new FindMinimumInRotatedSortedArray_153();
        System.out.println(find.finMin(new int[]{5,4,3,2,1}));
    }
}
