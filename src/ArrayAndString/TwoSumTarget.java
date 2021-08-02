package ArrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname TwoSumTarget
 * @Description 在twoSum2的基础上添加如下修改：
 *              nums中可能有多对元素之和等于target，返回所有和为target的元素对，并且不能出现重复
 * @Author likui
 * @Date 2021/8/1 21:34
 **/
public class TwoSumTarget {
    /**
     * 时间复杂度O(N)，排序复杂度O(logN),函数时间复杂度O(NlogN)
     *
     * @param nums
     * @param start 为了后面3Sum和4Sum可以复用该函数
     * @param target
     * @return
     */
    public static List<List<Integer>> twoSum(int[] nums,int start,int target){
        //数组不一定有序，先给数组排序才能使用二分搜索
        //如果调用该函数的函数中nums已经排过序，那么这里就不用再排序了
        Arrays.sort(nums);
//        int low=0;
        int low=start;//为了后面3Sum和4Sum可以复用该函数，这里从start开始
        int high=nums.length-1;
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list;
        //注意这里不是<=，因为是要找和为target的两个数
        while (low<high){
            int sum=nums[low]+nums[high];
            //记录索引low和high最初对应的值，用于跳过重复部分
            int left=nums[low],right=nums[high];
            if(sum<target){
                while (low<high&&nums[low]==left)
                    low++;
            }else if(sum>target){
                while (low<high&&nums[high]==right)
                    high--;
            }else {
                //将第一次满足结果的值加入集合
                list=new ArrayList<>();
                list.add(left);
                list.add(right);
                res.add(list);
                //从左向右遍历跳过重复部分
                while (low<high&&nums[low]==left)
                    low++;
                //从右向左遍历跳过重复部分
                while (low<high&&nums[high]==right)
                    high--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        twoSum(new int[]{1,1,1,2,2,3,3},0,4).forEach(System.out::println);
    }
}
