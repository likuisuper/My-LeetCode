package ArrayAndString;

/*
最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。
 */

//方法一：水平(横向)扫描法
/*
public class LongestCommonPrefix_14 {
    public static String longestCommonPrefix(String[] strs){
        if(strs.length==0)
            return "";
        String prefix=strs[0];
        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(prefix)!=0){//即strs没有匹配到prefix字符串
                prefix=prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"abcd","ab"}));
    }

 */

/*方法二：垂直(纵向)扫描法
想象数组的末尾有一个非常短的字符串，使用上述方法依旧会进行S次比较。优化这类情况的一种方法就是纵向扫描。
我们从前往后枚举字符串的每一列，先比较每个字符串相同列上的字符（即不同字符串相同下标的字符）然后再进行对下一列的比较。

public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs){
        if(strs==null||strs.length==0)
            return "";
        for(int i=0;i<strs[0].length();i++){
            char c=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(i==strs[j].length()||strs[j].charAt(i)!=c)
                    return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        LongestCommonPrefix_14 l=new LongestCommonPrefix_14();
        System.out.println(l.longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}

 */

/*
方法三：分治法
我们使用分治的技巧，将原问题 LCP(Si...Sj)
分成两个子问题 LCP(Si...Smid)与 LCP(Smid+1, Sj)
其中 mid =(i+j)/2
我们用子问题的解 lcpLeft 与 lcpRight 构造原问题的解 LCP(Si...Sj)
从头到尾挨个比较 lcpLeft 与 lcpRight 中的字符，直到不能再匹配为止。 计算所得的 lcpLeft 与 lcpRight
 最长公共前缀就是原问题的解 LCP(Si...Sj)

 */
public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs){
        if(strs==null||strs.length==0)
            return "";
        return longestCommonPrefix(strs,0,strs.length-1);
    }
    public String longestCommonPrefix(String[] strs,int l,int r){
        if(l==r)
            return strs[l];
        else{
            int mid=(l+r)/2;
            String lcpleft=longestCommonPrefix(strs,l,mid);
            String lcpright=longestCommonPrefix(strs,mid+1,r);
            return commonPrefix(lcpleft,lcpright);
        }
    }
    public String commonPrefix(String left,String right){
        int min=Math.min(left.length(),right.length());
        for(int i=0;i<min;i++){
            if(left.charAt(i)!=right.charAt(i))
                return left.substring(0,i);
        }
        return left.substring(0,min);
    }

    public static void main(String[] args) {
        LongestCommonPrefix_14 l=new LongestCommonPrefix_14();
        System.out.println(l.longestCommonPrefix(new String[]{"leetcode","leet","lee","le"}));
    }
}
