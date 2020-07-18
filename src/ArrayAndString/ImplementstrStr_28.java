package ArrayAndString;
/*
实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */

//第一种方法：KMP算法
public class ImplementstrStr_28 {
    public int[] getNext(String part){
        int[] next=new int[part.length()];
        int k=-1,j=0;
        next[0]=-1;
        while(j<part.length()-1){
            if(k==-1||part.charAt(j)==part.charAt(k)){
                k++;
                j++;
                if(part.charAt(j)!=part.charAt(k))
                    next[j]=k;
                else
                    next[j]=next[k];
            }
            else
                k=next[k];
        }
        return next;
    }
    public int strStr(String haystack, String needle) {
        if(needle==null||needle.length()==0)
            return 0;
        int i=0,j=0;
        int[] next=getNext(needle);
        while(i<haystack.length()&&j<needle.length()){
            if(j==-1||haystack.charAt(i)==needle.charAt(j)){
                ++i;
                ++j;
            }
            else
                j=next[j];
        }
        if(j>=needle.length())
            return i-j;
        else
            return -1;
    }

    public static void main(String[] args) {
        ImplementstrStr_28 i=new ImplementstrStr_28();
        String haystack="aaaaa";
        String needle="";
        int index=i.strStr(haystack,needle);
        System.out.println(index);
    }

    //第二种方法，String的indexof()方法
    /*
    public class ImplementstrStr_28 {
        public int strStr(String haystack, String needle) {
            return haystack.indexOf(needle);
        }
    }
     */

    //第三种方法:暴力匹配
    /*
        public class ImplementstrStr_28 {
        public int strStr(String haystack, String needle) {
            int l1=haystack.length();
            int l2=needle.length();
            int i=0,j=0;
            while(i<l1&&j<l2){
                if(haystack.charAt(i)==needle.charAt(j)){
                    ++i;
                    ++j;
                }
                else{
                    i=i-j+1;
                    j=0;
                }
            }
            if(j>=l2)
                return i-j;
            else
                return -1;
        }
    }
     */
}
