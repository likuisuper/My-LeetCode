package offer.divide_conquer;

/**
 * @Classname Power_16
 * @Description 数值的整数次方。相当于实现一个pow函数
 * @Author likui
 * @Date 2021/7/9 22:55
 **/
public class Power_16 {
    /**
     * 求2的32次方，可以分解为求 2^1->2^2->2^4->2^8->2^16
     * 将原先为O(N)的时间复杂度降低到O(logN)
     * 0的0次方是没有意义的，返回0和1都可以
     * @param base 基数
     * @param exponent 指数
     * @return
     */
    public double power(double base, int exponent) {
        //指数负数标记
        boolean isNagetive = false;
        if (exponent < 0) {
            exponent = -exponent;
            isNagetive = true;
        }
        double result=helper(base,exponent);
        //当指数是负数的时候，先求出结果后，还要求出它的倒数，比如 2^-2 --> 1/2^2
        return isNagetive?1/result:result;
    }

    private double helper(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        //采用位运算提高性能
        double result=helper(base,exponent>>1);
        result*=result;
        //当出现指数是奇数的时候，还要将结果再乘上基数
        if((exponent&1)==1){
            result=result*base;
        }
        return result;
    }

    public static void main(String[] args) {
        Power_16 power_16=new Power_16();
        System.out.println(power_16.power(0, 2));
        System.out.println(Math.pow(0,32));
    }
}
