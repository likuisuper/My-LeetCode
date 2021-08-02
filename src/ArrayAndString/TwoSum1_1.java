package ArrayAndString;

import java.util.HashMap;

/**
 * @Classname TwoSum1_1
 * @Description 两数之和
 * @Author likui
 * @Date 2021/8/1 20:48
 **/
public class TwoSum1_1 {
    public int[] twoSum(int[] nums,int target){
        //保存每个数对应的索引
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < n; i++) {
            int other=target-nums[i];
            //other存在且不是nums[i]本身
            if(map.containsKey(other)&&map.get(other)!=i){
                return new int[]{i,map.get(other)};
            }
        }
        return new int[]{-1,-1};
    }
}
