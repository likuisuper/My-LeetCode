package ArrayAndString;

/*
旋转数组

给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释:
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
说明:

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的 原地 算法
 */

public class RotateArray_189 {
    /*方法一：暴力解法
    public void rotate(int[] nums,int k){
        int temp,previous;
        for(int i=0;i<k;i++){
            previous=nums[nums.length-1];
            for(int j=0;j<nums.length;j++){
                temp=nums[j];
                nums[j]=previous;
                previous=temp;
            }
        }
    }
     */

    /*方法二：使用额外的数组，空间复杂度为O(n)
    public void rotate(int[] nums,int k){
        int[] a=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            a[(i+k)%nums.length]=nums[i];//通过取余就可以不超出数组的索引
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=a[i];
        }
    }

     */

    //方法三：使用反转，因为旋转数组k次，k%n个尾部元素会被移动到头部，剩下的元素会向后移动
    public void rotate(int[] nums,int k){
        k%=nums.length;
        reverse(nums,0,nums.length-1);//第一步:反转数组所有的元素
        reverse(nums,0,k-1);//第二步：反转前k个元素
        reverse(nums,k,nums.length-1);//第三步：反转后n-k个元素
    }
    public void reverse(int[] nums,int start,int end){
        while(start<end){
            int tmp=nums[start];
            nums[start]=nums[end];
            nums[end]=tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        RotateArray_189 r=new RotateArray_189();
        int[] nums=new int[]{1,2,3,4,5,6,7};
        r.rotate(nums,8);
        for(int num:nums){
            System.out.println(num);
        }
    }
}
