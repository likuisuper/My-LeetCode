package offer.two_point;

import java.util.ArrayList;

/**
 * @Classname TwoNumbersWithSum_57_02
 * @Description 和为s的连续正数序列：输入一个正数sum，打印出所有和为sum的连续正数序列（至少含有两个数）
 * @Author likui
 * @Date 2021/7/2 23:10
 **/
public class TwoNumbersWithSum_57_02 {
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if(sum<3){
            return result;
        }
        //一个序列至少包含两个数
        int start=1,end=2;
        //记录当前序列的和
        int currentSum=3;
        while (end<sum){
            if(currentSum>sum){
                //如果当前序列的和已经大于给定的和，那么要减小当前序列的和
                //先减小当前序列的和，再增加start的值
                currentSum-=start;
                start++;
            }else if(currentSum<sum){
                //如果当前序列的和小于给定的和，那么让序列包含更多的数
                //先增加end的值
                end++;
                currentSum+=end;
            }else {
                //说明当前序列的和等于给定的和
                //遍历当前这个序列，添加进list
                ArrayList<Integer> list=new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                result.add(list);
                //可能存在下一个序列的和也等于给定的和
                //所以要移动到下一个序列
                //减去当前序列的第一个数，然后两边++
                currentSum-=start;
                start++;
                end++;
                currentSum+=end;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoNumbersWithSum_57_02 t=new TwoNumbersWithSum_57_02();
        System.out.println(t.findContinuousSequence(12));
    }
}
