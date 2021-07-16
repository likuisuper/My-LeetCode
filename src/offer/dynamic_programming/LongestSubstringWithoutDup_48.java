package offer.dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname LongestSubstringWithoutDup_48
 * @Description 最长不包含重复字符的子字符串
 *              输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。
 *              例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
 *              需要注意，既然是子串，那么肯定是连续的，要和子序列区分开。比如"pwwkew"，那么输出的是3，即wke，而不是pwke
 * @Author likui
 * @Date 2021/7/15 22:06
 **/
public class LongestSubstringWithoutDup_48 {
    /**
     * dp[i]的含义：以mums[i]结尾的不包含重复字符的最长子字符串
     * 由于dp[i]只和dp[i-1]有关，所以这里对dp数组进行了状态压缩
     * 时间复杂度：O(N)
     * 空间复杂度：O(26)=O(1)
     * 力扣上提交会报数组越界异常
     * @param str
     * @return
     */
    public int longestSubStringWithoutDuplication(String str){
        //当前不重复子字符串串的长度
        //它就相当于dp[i]和dp[i-1]
        int curLen=0;
        //记录最大不重复子字符串的长度
        int maxLen=0;
        //定义一个长度为26的数组（a~Z，即26个字符)
        //用来存放每个字符上次出现在子字符串中位置的下标
        int[] preIndexs=new int[26];
        //初始化都为-1，表示对应的字符在字符串中还没出现过
        Arrays.fill(preIndexs,-1);
        for (int curIndex = 0; curIndex < str.length(); curIndex++) {
            //得到当前字符的下标
            int index = str.charAt(curIndex) - 'a';
            //得到当前字符在数组中对应的下标，判断当前字符是否出现过
            int preIndex = preIndexs[index];
            //如果第i个字符没有出现过，即没有重复，那么dp[i]=dp[i-1]+1
            //如果第i个字符出现过，并且当前所在位置 - 该字符上次出现的位置d>dp[i-1]
            //说明第i个字符上次出现在dp[i-1]对应的最长子字符串之前
            //仍然有dp[i]=dp[i-1]+1
            if(preIndex==-1||curIndex-preIndex>curLen){
                curLen++;
            }else {
                //如果第i个字符出现过，并且当前所在位置 -该字符上次出现的位置（记为d）<= dp[i-1]，
                //也就是说第i个字符上次出现在dp[i-1]对应的最长子字符串之中
                //此时dp[i]=d
                //先记录最大长度
                maxLen=Math.max(maxLen,curLen);
                //然后更新当前不重复子字符串的长度
                curLen=curIndex-preIndex;
            }
            //将当前字符下标放入数组
            preIndexs[index]=curIndex;
        }
        maxLen=Math.max(maxLen,curLen);
        return maxLen;
    }


    /**
     * 动态规划+哈希表
     * 时间复杂度：O(N)
     * 空间复杂度：O(128)=O(1)，字符的ascii范围0~127
     * @param str
     * @return
     */
    public int longestSubStringWithoutDuplication2(String str){
        Map<Character,Integer> map=new HashMap<>();
        int temp=0;
        int max=0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            //获取索引，-1表示该字符没有出现过
            Integer index = map.getOrDefault(c, -1);
            //更新字符出现的位置
            map.put(c,i);
            //和上面方法一样，分不重复和重复，重复中的一种情况和不重复是一样的
            temp=temp<i-index?temp+1:i-index;
            //max(dp[i-1],dp[i])
            max=Math.max(max,temp);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println('z'-'a');
    }
}
