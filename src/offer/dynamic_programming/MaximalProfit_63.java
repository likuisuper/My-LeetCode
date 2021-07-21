package offer.dynamic_programming;

/**
 * @Classname MaximalProfit_63
 * @Description 股票的最大利润（买卖股票的最佳时机）
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * @Author likui
 * @Date 2021/7/20 22:56
 **/
public class MaximalProfit_63 {
    /**
     * 动态规划，并且由题目可知交易次数只有一次
     * 如果是可以交易多次，那么有dp[i][k][j]
     * 交易一次是可交易多次的特殊情况，相当于k=1
     * 具体模板见 https://labuladong.gitee.io/algo/3/27/88/
     * dp[2][1]表示第二天持有股票
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        //dp[i][j]定义：第i天持有股票（j=1）或不持有股票（j=0）的最大利润
        int[][] dp = new int[n + 1][2];

        //base case
        //-1表示还没开始，并且没有持有股票，那么此时利润为0
        //dp[-1][0]=0;
        //还没开始，但是却持有股票，不可能，负无穷表示
        //dp[-1][1]=-infinity;
        for (int i = 0; i < n; i++) {
            //base case，处理i=-1的情况
            if (i - 1 == -1) {
                //dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i])
                //==>dp[i][0]=Math.max(dp[-1][0],dp[-1][1]+prices[i])
                //==>dp[i][0]=Math.max(0,-infinity+prices[i])=0
                dp[i][0] = 0;
                //dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i])
                //==>dp[i][1]=Math.max(dp[-1][1],dp[-1][0]-prices[i])
                //==>dp[i][1]=Math.max(-infinity,0-prices[i])=-prices[i]
                dp[i][1]=-prices[i];
                continue;
            }
            //第i天没有持有股票，有2种情况
            //1、前一天就没有持有股票，并且第i天没有任何操作
            //2、前一天持有股票，但是第i天出售了股票，那么此时要给利润加上prices[i]
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            //第i天持有股票，有2种情况
            //1、前一天就持有股票，并且第i天没有任何操作
            //2、前一天没有持有股票，但是第i天买入了股票，此时要从利润中减去prices[i]
            //dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
        }
        //返回最后一天没有持有股票的最大利润，股票卖出去的利润大于没有卖出去的利润
        return dp[n-1][0];
    }

    /**
     * 状态压缩
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices){
        int n=prices.length;
        int dp_i_0=0;
        int dp_i_1=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            //dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp_i_0=Math.max(dp_i_0,dp_i_1+prices[i]);
            //dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
            dp_i_1=Math.max(dp_i_1,-prices[i]);
        }
        //返回最后一天没有持有股票的最大利润
        return dp_i_0;
    }
}
