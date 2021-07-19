package offer.dynamic_programming;

/**
 * @Classname ConstructArray_66
 * @Description 构建乘积数组
 *              给定一个数组 A[0, 1,..., n-1]，请构建一个数组 B[0, 1,..., n-1]，
 *              其中 B 中的元素 B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。要求不能使用除法。
 * @Author likui
 * @Date 2021/7/18 23:04
 **/
public class ConstructArray_66 {
    /**
     * 分成两部分
     * A[0]*...*A[i-1]和A[i+1]*...*A[n-2]*A[n-1]
     * A[i]=左边部分*右边部分
     * 左边：left[i]=A[0]*...*A[i-1],left[i+1]=A[0]*...*A[i]==>left[i+1]=left[i]*A[i]
     * 右边：right[i]=A[i+1]*...*A[n-2]*A[n-1],right[i+1]=A[i+2]*...*A[n-1]==>right[i]=A[i+1]*right[i+1]
     * 可以将左边看成正三角，右边看成倒三角。先求正三角，再求倒三角
     * 动态规划，dp[i]数组的定义为：A数组中，下标为i的数的乘积
     * @param A
     * @return
     */
    public int[] multiply(int[] A){
        int length=A.length;
        if(length<=0)
            return new int[0];
        //构建数组B
        int[] B=new int[length];
        B[0]=1;
        //temp可以看成right[i]
        int temp=1;
        //从左往右累乘
        for (int i = 1; i < length; i++) {
            B[i]=B[i-1]*A[i-1];
        }
        //从右往左累乘
        //i要从length-2开始，不然+1就超过数组长度了
        for(int i=length-2;i>=0;i--){
            temp*=A[i+1];
            //前面从左往右类乘后的B数组乘以temp值
            B[i]*=temp;
        }
        return B;
    }
}
