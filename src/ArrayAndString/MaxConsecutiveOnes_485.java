package ArrayAndString;

/*
最大连续1的个数

给定一个二进制数组， 计算其中最大连续1的个数。

示例 1:

输入: [1,1,0,1,1,1]
输出: 3
解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
注意：

输入的数组只包含 0 和1。
输入数组的长度是正整数，且不超过 10,000。
 */
public class MaxConsecutiveOnes_485 {
    /*双指针的最高境界：滑动窗口
    滑动窗口思路：
    当输出或比较的结果在原数据结构中是连续排列的时候，可以使用滑动窗口算法求解。
    将两个指针比作一个窗口，通过移动指针的位置改变窗口的大小，观察窗口中的元素是否符合题意。

    初始窗口中只有数组开头一个元素。
    当窗口中所有元素为 1 时，右指针向右移，扩大窗口。
    当窗口中存在 0 时，计算连续序列长度，左指针指向右指针。
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int length=nums.length;
        int left=0,right=0;
        int maxSize=0;
        while(right<length){
            if(nums[right++]==0){//这里是先判断nums[right]的值是否==0,然后再让right++
                maxSize=Math.max(maxSize,right-left-1);//计算连续序列的长度
                left=right;//左指针指向右指针
            }
        }
        //因为最后一次连续序列在循环中无法比较，所以在循环外比较
        return Math.max(maxSize,right-left);
    }

    /*
        public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int right = 0;
        int max = 0;
        int temp = 0;
        int length = nums.length;

        while(right < length){
            if(nums[right] != 0){
                right++;
            }else{
                right++;
                temp = right - left - 1;
                if(temp > max){
                    max = temp;
                }
                left = right;
            }
        }
        return max>(right - left)?max:(right - left);
    }
     */

    public static void main(String[] args) {
        MaxConsecutiveOnes_485 m=new MaxConsecutiveOnes_485();
        System.out.println(m.findMaxConsecutiveOnes(new int[]{1,1,1,0,1,1}));
    }
}
