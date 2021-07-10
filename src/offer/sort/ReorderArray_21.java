package offer.sort;

import java.util.Arrays;

/**
 * @Classname ReorderArray_21
 * @Description 调整数组顺序使奇数位于偶数前面
 * @Author likui
 * @Date 2021/7/10 22:09
 **/
public class ReorderArray_21 {
    /**
     * 快慢指针
     * @param array
     * @return
     */
    public int[] reOrderArray1(int[] array){
        if(array==null||array.length==0)
            return array;
        //slow指向下一个奇数要存放的位置，fast用来搜索奇数
        int slow=0,fast=0;
        while (fast<array.length){
            if((array[fast]&1)==1){
                //如果fast遇到奇数，那么交换
                array[slow]=array[fast]^(array[fast]=array[slow])^array[slow];
                slow++;
            }
            fast++;
        }
        return array;
    }

    /**
     * 首尾指针
     * left指针：一直向右移，直到所指的数为偶数
     * right指针：一直左移，直到所指的数为奇数
     * @param array
     * @return
     */
    public static int[] reOrderArray2(int[] array){
        if(array==null||array.length==0)
            return array;
        int left=0,right=array.length-1;
        while (left<right){
            if((array[left]&1)==1){
                left++;
                continue;
            }
            if((array[right]&1)==0){
                right--;
                continue;
            }
            array[left]=array[right]^(array[right]=array[left])^array[left];
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(reOrderArray2(new int[]{1, 2, 3, 4, 5})));
    }
}
