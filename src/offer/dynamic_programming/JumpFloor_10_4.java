package offer.dynamic_programming;

/**
 * @Classname JumpFloor_10_4
 * @Description 变态跳台阶，除了一次跳一级、一次跳两级，还可以一次跳n级
 *              跳上n-1级台阶，可以从n-2级跳一级上去，也可以从n-3级跳两级上去：
 *              f(n-1)=f(n-2)+f(n-3)+...+f(0)
 *              跳上n级台阶，可以从n-2级跳两级上去，也可以从n-1级跳一级上去：
 *              f(n)=f(n-1)+f(n-2)+...+f(0)
 *              两者相减，有f(n)-f(n-1)=f(n-1)，即f(n)=2f(n-1)
 * @Author likui
 * @Date 2021/7/13 21:55
 **/
public class JumpFloor_10_4 {
    public int jumpFloor(int n){
        return (int) Math.pow(2,n-1);
    }
}
