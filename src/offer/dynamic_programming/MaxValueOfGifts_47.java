package offer.dynamic_programming;

/**
 * @Classname MaxValueOfGifts_47
 * @Description 礼物的最大值
 * @Author likui
 * @Date 2021/7/14 23:01
 **/
public class MaxValueOfGifts_47{
    /**
     * 时间复杂度O(N^2)
     * 空间复杂度O(M*N)
     * @param array
     * @return
     */
    public int getMost(int[][] array){
        if(array.length<=0||array[0].length<=0)
            return 0;
        //行
        int row=array.length;
        //列
        int cow=array[0].length;
        //dp数组的含义：从左上角到达位置(i,j)的最大路径和是dp[i][j]
        //那么dp[row-1][cow-1]即为所求（右下角）
        int[][] dp=new int[row][cow];
        dp[0][0]=array[0][0];
        //初始化，防止出现0-1为负数的情况
        //初始化最左边的列，只能往下走
        for (int i = 1; i < row; i++) {
            //因为dp中保存的是路径和，所以是原数组中到达的位置+前面的路径
            dp[i][0]=array[i][0]+dp[i-1][0];
        }
        //初始化最上面的行，只能往右走
        for (int j = 1; j < cow; j++) {
            //同上
            dp[0][j]=array[0][j]+dp[0][j-1];
        }

        //求dp[row-1][cow-1]
        for (int i = 1; i < row; i++) {
            for(int j=1;j< cow;j++){
                //怎么到达(i,j)这个位置呢？
                //一种是向下走一步，即(i-1,j)
                //一种是向右走一步，即(i,j-1)
                //最后还有当前的位置
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+array[i][j];
            }
        }
        //返回dp数组右下角的值，即为最大路径和
        return dp[row-1][cow-1];
    }

    /**
     * 状态压缩：因为dp[i][j]只与dp[i-1][j],dp[i][j-1],array[i,j]有关
     * 所以可以只在原数组上修改
     * 空间复杂度O(1)
     * @param array
     * @return
     */
    public int getMost2(int[][] array){
        if(array.length<=0||array[0].length<=0)
            return 0;
        //行
        int row=array.length;
        //列
        int cow=array[0].length;

        //初始化，防止出现0-1为负数的情况
        //初始化最左边的列，只能往下走
        for (int i = 1; i < row; i++) {
            //数组中到达的位置+前面的路径
            array[i][0]=array[i][0]+array[i-1][0];
        }
        //初始化最上面的行，只能往右走
        for (int j = 1; j < cow; j++) {
            //同上
            array[0][j]=array[0][j]+array[0][j-1];
        }

        for (int i = 1; i < row; i++) {
            for(int j=1;j< cow;j++){
                //怎么到达(i,j)这个位置呢？
                //一种是向下走一步，即(i-1,j)
                //一种是向右走一步，即(i,j-1)
                //最后还有当前的位置
                array[i][j]=Math.max(array[i-1][j],array[i][j-1])+array[i][j];
            }
        }
        //返回数组右下角的值，即为最大路径和
        return array[row-1][cow-1];
    }
}

