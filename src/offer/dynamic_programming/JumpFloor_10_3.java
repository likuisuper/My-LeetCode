package offer.dynamic_programming;

/**
 * @Classname JumpFloor_10_3
 * @Description 青蛙跳台阶。青蛙可以一次跳一个台阶，也可以一次跳2个台阶
 *              则跳到n级台阶共有多少种跳法
 * @Author likui
 * @Date 2021/7/13 21:06
 **/
public class JumpFloor_10_3 {
    /**
     * 动态规划
     * 1、明确dp数组的含义
     * 2、找出数组元素间的关系（状态转移方程）
     * 3、确定初始值
     * @param n
     * @return
     */
    public int jumpFloor(int n){
        //base case
        if(n<=2)
            return n;
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <= n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    /**
     * 和斐波那契数列一样，进行状态压缩
     * @param n
     * @return
     */
    public int jumpFloo2(int n){
        //base case
        if(n<=2)
            return n;
        int pre1=1;
        int pre2=2;
        int result=0;
        for (int i = 3; i <= n; i++) {
            result=pre2+pre1;
            pre1=pre2;
            pre2=result;
        }
        return result;
    }
}
