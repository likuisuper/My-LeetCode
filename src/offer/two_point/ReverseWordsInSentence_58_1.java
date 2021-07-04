package offer.two_point;

import java.util.Arrays;

/**
 * @Classname ReverseWordsInSentence_58_1
 * @Description 翻转字符串。单词内的顺序不变
 * @Author likui
 * @Date 2021/7/3 20:58
 **/
public class ReverseWordsInSentence_58_1 {

    public String reverseSentence2(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        //维护两个快慢指针，i用来指向空格后的单词，j用来遍历单词
        int i = 0, j = 0;
        while (j <= n) {
            //遇到空格翻转空格前的一个单词或者翻转最后一个单词
            if (j == n || chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        //翻转整个字符串
        reverse(chars, 0, n - 1);
        return new String(chars);
    }

    private void reverse(char[] c, int i, int j) {
        while (i < j)
            swap(c, i++, j--);
    }

    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }

    public static void main(String[] args) {
        ReverseWordsInSentence_58_1 r=new ReverseWordsInSentence_58_1();
        String str="abcdefg";
        System.out.println(r.reverseSentence2(str));
    }
}
