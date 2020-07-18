package ArrayAndString;

import java.util.*;

/*
翻转字符串里的单词

给定一个字符串，逐个翻转字符串中的每个单词。

示例 1：

输入: "the sky is blue"
输出: "blue is sky the"
示例 2：

输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
示例 3：

输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。


说明：

无空格字符构成一个单词。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class ReverseWordsinaString_151 {
    /*方法一：使用语言特性
    1：使用spilt将字符串按空格分隔成字符串数组
    2：使用reserve将字符串数组进行反转
    3：使用Join方法将字符串数组拼接成一个字符串
    public String reverseWords(String s) {
        //除去开头和末尾的空白字符
        s=s.trim();
        //正则匹配连续的空白字符作为分隔符分割
        List<String> wordList= Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);//反转
        return String.join(" ",wordList);
    }
     */

    /*
    方法二：双端队列：由于双端队列支持从队列头部插入的方法，因此我们可以沿着字符串一个一个单词处理，
    然后将单词压入队列的头部，再将队列转成字符串即可。
     */
    public String reverseWords(String s){
        int left=0,right=s.length()-1;
        //去掉字符串开头的空白字符
        while(left<=right&&s.charAt(left)==' ')
            ++left;
        //去掉字符串末尾的空白字符
        while(left<=right&&s.charAt(right)==' ')
            --right;
        Deque<String> d=new ArrayDeque<>();
        StringBuilder word=new StringBuilder();
        while (left<=right){
            char c=s.charAt(left);
            if(word.length()!=0&&(c==' ')){
                //将单词push到队列的头部,实现翻转
                d.offerFirst(word.toString());
                word.setLength(0);
            }
            else if(c!=' ')
                word.append(c);
            ++left;
        }
        d.offerFirst(word.toString());//最后一个单词只能在循环外添加到队列头部，因为循环里的if条件不满足
        return String.join(" ",d);
    }

    public static void main(String[] args) {
        ReverseWordsinaString_151 r=new ReverseWordsinaString_151();
        String s="    a good    example     ";
        System.out.println(r.reverseWords(s));
    }
}
