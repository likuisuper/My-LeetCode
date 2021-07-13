package offer.dynamic_programming;

/**
 * @Classname Fibonacci_10
 * @Description 求斐波那契数列的第n项
 * @Author likui
 * @Date 2021/7/12 21:29
 **/
public class Fibonacci_10 {
    /**
     * 暴力解法。存在重叠子问题
     * 时间复杂度：O(N^2)
     * 空间复杂度：递归栈的空间
     * @param n
     * @return
     */
    public int fibonacci1(int n) {
        if(n==0)
            return 0;
        if(n==1||n==2)
            return 1;
        return fibonacci1(n-1)+fibonacci1(n-2);
    }

    /**
     * 带备忘录的递归，自顶向下
     * 时间复杂度：不存在重复计算，O(N)
     * 空间复杂度：O(N)，额外的数组空间
     * @param n
     * @return
     */
    public int fibonacci2(int n){
        if(n<1)
            return 0;
        int[] temp=new int[n+1];
        return helper(temp,n);
    }

    private int helper(int[] nums,int n){
        //base case
        if(n==1||n==2)
            return 1;
        //如果已经计算过，就保存，防止重复计算
        if(nums[n]!=0)
            return nums[n];
        nums[n]=helper(nums,n-1)+helper(nums,n-2);
        return nums[n];
    }

    /**
     * 动态规划，使用dp数组，自底向上
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param n
     * @return
     */
    public int fibonacci3(int n){
        if(n<1)
            return 0;
        if(n==1||n==2)
            return 1;
        //为什么数组大小是n+1呢？从0到n就是n+1
        int[] temp=new int[n+1];
        //base case
        temp[1]=temp[2]=1;
        for (int i = 3; i <= n; i++) {
            temp[i]=temp[i-1]+temp[i-2];
        }
        return temp[n];
    }

    /**
     * 根据状态转移方程，当前状态之和之前的两个状态有关，所以不需要dp数组来
     * 存储所有的状态，只需要存值前2个状态即可。这就是状态压缩
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    public int fibonacci4(int n){
        if(n<1)
            return 0;
        if(n==1||n==2)
            return 1;
        int pre=1;
        int cur=1;
        for (int i = 3; i <= n; i++) {
            int sum=pre+cur;
            pre=cur;
            cur=sum;
        }
        return cur;
    }
}
