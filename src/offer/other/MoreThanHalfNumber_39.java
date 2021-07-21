package offer.other;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname MoreThanHalfNumber_39
 * @Description 数组中出现次数超过数组长度一半的数字
 * @Author likui
 * @Date 2021/7/21 21:24
 **/
public class MoreThanHalfNumber_39 {
    /**
     * 使用一个map保存数组中每个数对应的次数
     * 时间和空间复杂度都是O(N)
     * @param numbers
     * @return
     */
    public static int moreThanHalfNumber(int[] numbers){
        int n=numbers.length;
        if(numbers==null||n<=0)
            return 0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int number : numbers) {
            map.put(number,map.getOrDefault(number,0)+1);
        }
        for (int number : numbers) {
            if(map.get(number)>n/2){
                return number;
            }
        }
        return 0;
    }

    /**
     * 多数投票问题（也可以理解为同归于尽），具体分析见力扣
     * 时间复杂度为O(N)
     * 空间复杂度为O(1)
     * @param numbers
     * @return
     */
    public static int moreThanHalfNumber2(int[] numbers){
        if(numbers==null||numbers.length<=0)
            return 0;
        //定义一个众数
        int x=0;
        //票数统计
        int votes=0;
        for (int number : numbers) {
            //如果当前票数为0，当前遍历的数成为众数
            if(votes==0)
                x=number;
            //如果当前遍历的数等于众数，那么票数+1，否则票数-1
            votes+=number==x?1:-1;
        }

        int count=0;
        //还需要考虑数组不存在众数的情况
        for (int number : numbers) {
            if(number==x)
                count++;
        }
        //无众数返回0
        return count>numbers.length/2?x:0;
    }

    public static void main(String[] args) {
        System.out.println(moreThanHalfNumber(new int[]{1, 2, 3, 2, 5, 4, 2}));
    }
}
