package ArrayAndString;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * @author cxylk
 * @date 2020/7/19 21:12
 */
public class SearchInsertPosition_35 {
    public int searchInsert(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){//小于目标值，就去右边找(即大的一边去找)
                left=mid+1;
            }
            else{//大于目标值，就去左边找(即小的一边去找)
                right=mid-1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SearchInsertPosition_35 s=new SearchInsertPosition_35();
        System.out.println(s.searchInsert(new int[]{1,3,5,6},2));
    }
}
