package offer.two_point;

import java.util.ArrayList;

/**
 * @Classname TwoNumbersWithSum_57_01
 * @Description 和为S的两个数字
 * @Author likui
 * @Date 2021/7/2 22:03
 **/
public class TwoNumbersWithSum_57_01 {
    public ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list=new ArrayList<>();
        if(array==null||array.length==0){
            return list;
        }
        int i=0,j=array.length-1;
        while (i<j){
            int target=array[i]+array[j];
            if(target>sum){
                j--;
            }else if(target<sum){
                i++;
            }else {
                list.add(array[i]);
                list.add(array[j]);
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TwoNumbersWithSum_57_01 t=new TwoNumbersWithSum_57_01();
        int[] array={1,8,4,7,11,15};
        System.out.println(t.findNumbersWithSum(array, 15));
    }
}
