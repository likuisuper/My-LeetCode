package offer.array_matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname DuplicationInArrayNoEdit_03_01
 * @Description 数组中重复的数字
 * @Author likui
 * @Date 2021/6/26 20:29
 **/
public class DuplicationInArrayNoEdit_03_01 {
    /**
     * 第一种解法，利用集合特性
     * 时间复杂度和空间复杂度都是O(N)
     * @param nums
     * @return
     */
    public int duplicate1(int[] nums){
        //利用哈希集合不含重复数据的特性
        Set<Integer> set=new HashSet<>();
        for (int num : nums) {
            //如果数已经在集合中存在，说明重复，返回该数
            if(set.contains(num))
                return num;
            //否则加入集合
            set.add(num);
        }
        return -1;
    }

    /**
     * 第二种方法，交互数组元素
     * 每个元素最多只要交换两次就能找到属于它自己的位置
     * @param nums
     * @return
     */
    public int duplicate2(int[] nums) {
        if(nums.length==0)
            return -1;
        //确保数组中的数合法
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<0||nums[i]>nums.length-1)
                return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]!=i){
                //说明该数和数组下标中已经存在的数相等，说明重复
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                //否则交互两个数，知道数组下标和数相等
                nums[i]=(nums[nums[i]])^(nums[nums[i]]=nums[i])^nums[i];
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        DuplicationInArrayNoEdit_03_01 test=new DuplicationInArrayNoEdit_03_01();
        System.out.println(test.duplicate2(new int[]{2, 1, 0, 4, 3}));
    }
}
