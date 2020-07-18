package ArrayAndString;

/*
删除排序数组中的重复项

给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

示例 1:

给定数组 nums = [1,1,2],

函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

你不需要考虑数组中超出新长度后面的元素。
示例 2:

给定 nums = [0,0,1,1,1,2,2,3,3,4],

函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicatesfromSortedArray_26 {
    /*
    首先注意数组是有序的，那么重复的元素一定是相邻的。我们可以放置两个指针i和j，其中i是慢指针，而j是快指针。
    只要 nums[i] = nums[j]，我们就增加j以跳过重复项。当我们遇到
    nums[j]！=nums[i]时，跳过重复项的运行已经结束，因此我们必须把nums[j]的值复制到nums[i+1]。
    然后递增i，接着我们将再次重复相同的过程，直到j到达数组的末尾为止。
     */

    /*
    public int removeDuplicates(int[] nums){
        if(nums.length==0)
            return 0;
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[i]){
                ++i;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
     */
    //优化后的算法，防止无重复元素的数组进行复制，这个操作是没有必要的
    public int removeDuplicates(int[] nums){
        if(nums.length==0)
            return 0;
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[i]){
                if(j-i>1)//这一步是为了防止无重复数字的数组复制，如1,2,3,4,5
                    nums[i+1]=nums[j];//复制元素
                ++i;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArray_26 r=new RemoveDuplicatesfromSortedArray_26();
        int[] nums=new int[]{0,0,1,1,1,2,2,3,3,4};
        int len=r.removeDuplicates(nums);
        for(int i=0;i<len;i++){
            System.out.println(nums[i]);
        }
    }
}
