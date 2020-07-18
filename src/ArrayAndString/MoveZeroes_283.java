package ArrayAndString;

import java.util.ArrayList;
import java.util.List;

/*
移动零

给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。
 */
public class MoveZeroes_283 {
    /*
    解法一：创建一个集合nonzeroelements,遍历nums,将非零元素复制到集合中，而后按顺序
    将集合中的元素复制到nums中，未遍历的元素置0。空间复杂度为O(n),不满足题意

    public void moveZeroes(int[] nums){
        //集合
        List<Integer> nonzeroelements=new ArrayList<>();
        //将nums中所有非零元素放入集合中
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nonzeroelements.add(nums[i]);
            }
        }
        //将集合中的所有元素依次放入到nums开始的位置
        for(int i=0;i<nonzeroelements.size();i++){
            nums[i]= nonzeroelements.get(i);
        }
        //将nums剩余的位置放置为0
        for(int i=nonzeroelements.size();i<nums.length;i++){
            nums[i]=0;
        }
    }
     */

    /*
    解法二：双指针。设定一个临时变量k=0，遍历数组nums,将非零元素移到nums[k]位置，同时k++,
    而后将[k-nums.length]中的元素置0。空间复杂度为O(1)

    public void moveZeroes(int[] nums){
        int k=0;//nums中，[0-k)的元素均为非零元素
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[k++]=nums[i];
            }
        }
        //将nums剩余的元素都置为0
        for(int i=k;i<nums.length;i++){
            nums[i]=0;
        }
    }
     */

    /*
    解法三：设定一个临时变量K，遍历数组nums，将非零元素与之前的0元素进行交换，维护变量K的值
     */
    public void moveZeroes(int[] nums){
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                if(k!=i){
                    int tmp=nums[k];
                    nums[k]=nums[i];
                    nums[i]=tmp;
                    k++;
                }
                else{
                    k++;
                }
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes_283 m=new MoveZeroes_283();
        int[] nums={1,3,12,4,5};
        m.moveZeroes(nums);
        for(int num:nums){
            System.out.println(num);
        }
    }
}
