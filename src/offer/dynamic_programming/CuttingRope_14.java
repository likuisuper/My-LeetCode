package offer.dynamic_programming;

/**
 * @Classname CuttingRope_14
 * @Description 剪绳子
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
 * 每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * @Author likui
 * @Date 2021/7/19 21:48
 **/
public class CuttingRope_14 {
    /**
     * 动态规划
     *
     * @param target
     * @return
     */
    public static int cutRope(int target) {
        //dp[i]：长度为i的绳子建成若干段后的最大乘积
        int[] dp = new int[target + 1];
        //base case
        //长度为2的绳子只有一种剪法
        dp[2] = 1;
        for (int i = 3; i <= target; i++) {
            //剪成j段，从长度为2开始剪
            for (int j = 2; j < i; j++) {
                //剪了第一段后，第二段可以不剪
                //如果不剪，那么乘积就是 j*(i-j)
                //如果剪，那么乘积就是j*dp[i-j],也就是第一段乘以第二段剪成若干段的最大乘积
                //不断修改剪的长度j。j的取值是[2,i)
                //等式右边为什么需要dp[i]，回到dp数组的定义，上一轮更新后乘积的最大值，
                //如果不和dp[i]比较的话，那么求得的就不是全局范围内的最大值
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[target];
    }

    /**
     * 贪心算法
     * 尽可能把绳子分成长度为3的小段，这样乘积更大
     *
     * @param target
     * @return
     */
    public static int cutRope2(int target) {
        //由于题目要求m>1，即最少剪一刀
        if (target < 4)
            return target - 1;
        int res = 1;
        while (target > 4) {
            //乘积乘以3
            res *= 3;
            //分成长度为3的小段
            target -= 3;
        }
        //长度为3的小段的乘积乘以小于等于4的最后一小段
        return res * target;
    }

    public static void main(String[] args) {
        System.out.println(cutRope(8));
    }
}
