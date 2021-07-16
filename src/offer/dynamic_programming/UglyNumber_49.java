package offer.dynamic_programming;

/**
 * @Classname UglyNumber_49
 * @Description 丑数。
 *              把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 *              习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @Author likui
 * @Date 2021/7/16 21:43
 **/
public class UglyNumber_49 {
    /**
     * 第一种解法。暴力解，遍历所有数
     * @param index
     * @return
     */
    public int getUglyNumber1(int index){
       if(index<=0)
           return 0;
       //从1开始判断是否是丑数
        int number=0;
       //遍历给定的数
       int uglyFound=0;
       while(uglyFound<index){
          number++;
          if(isUgly(number)){
              ++uglyFound;
          }
       }
       return number;
    }

    /**
     * 判断一个数是否是丑数
     * @param number
     * @return
     */
    private boolean isUgly(int number){
        while (number%2==0)
            number/=2;
        while (number%3==0)
            number/=3;
        while (number%5==0)
            number/=5;
        return number == 1;
    }

    /**
     * 动态规划，空间换时间
     * @param index
     * @return
     */
    public int getUglyNumber2(int index){
        if(index<=6)
            return index;
        //存放已排序的丑数
        int[] dp=new int[index];
        dp[0]=1;
        //初始化3个指针指向三个潜在成为最小丑数的位置
        int i2=0,i3=0,i5=0;
        for (int i = 0; i < index; i++) {
            //丑数是另一个丑数乘以2,3,5的结果，对不是丑数的数不进行计算
            int next2=dp[i2]*2,next3=dp[i3]*3,next5=dp[i5]*5;
            //因为需要保证有序，总是找到最小的丑数
            dp[i]=Math.min(next2,Math.min(next3,next5 ));
            //选为最小值后，对应指针加1
            //为了避免重复，所以3个if都要走到，比如丑数6，那么i2和i3都要加加
            if(dp[i]==next2)
                i2++;
            if(dp[i]==next3)
                i3++;
            if(dp[i]==next5)
                i5++;
        }
        return dp[index-1];
    }
}
