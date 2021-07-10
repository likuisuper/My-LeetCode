package offer.sort;

import java.util.Arrays;

/**
 * @Classname SortArrayForMinNumber_45
 * @Description 把数组排成最小的数：将输入数组里所有数字拼接起来排成一个数，
 *              打印能拼接出的所有数字中的最小的一个。例如，输出{3,32,321}，则打印这3个数字能排成的最小数字321323
 * @Author likui
 * @Date 2021/7/10 23:25
 **/
public class SortArrayForMinNumber_45 {
    /**
     * 可以看成是一个排序问题，在比较两个字符串S1和S2的时候
     * 应该比较的是S1+S2和S2+S1,如果S1+S2<S2+S1，则应该把S1排在前面，否则把S2排在前面
     * @param numbers
     * @return
     */
    public String printMinNumber(int [] numbers) {
        if(numbers==null||numbers.length==0)
            return "";
        int n=numbers.length;
        String[] result=new String[n];
        for (int i = 0; i < n; i++) {
            result[i]=numbers[i]+"";
        }
        Arrays.sort(result,(s1,s2)->(s1+s2).compareTo(s2+s1));
        String str="";
        for (String s : result) {
            str+=s;
        }
        return str;
    }
}
