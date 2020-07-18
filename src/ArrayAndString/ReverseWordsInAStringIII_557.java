package ArrayAndString;

/*
反转字符串中的单词 III

给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例 1:

输入: "Let's take LeetCode contest"
输出: "s'teL ekat edoCteeL tsetnoc"
注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class ReverseWordsInAStringIII_557 {
    /*
    方法 1：简单的解法 [Accepted]
    第一种方法非常简单，我们将输入字符串中按照空白字符串分开，然后把所有单词放到一个字符串列表中，
    然后我们逐一遍历每一个字符串并把反转结果连接起来。最后，我们将删除了额外空白字符的字符串返回。
    public String reverseWords(String s){
        String[] words=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(String word:words){
            sb.append(new StringBuffer(word).reverse().toString()+" ");
        }
        return sb.toString().trim();
    }

     */

    //方法二：滑动窗口
    public String reverseWords(String s) {
        char[] sentence = s.toCharArray();
        int i = 0, j = 0;
        while(j < sentence.length) {
            while(i < sentence.length && sentence[i] == ' ') ++i;
            while(j < sentence.length && sentence[j] != ' ') ++j;
            reverse(sentence, i, j - 1);
            i = j;
            ++j;
        }
        s = String.valueOf(sentence);
        return s.trim();
    }

    private void reverse(char[] arr, int start, int end) {
        if (arr.length == 0) return;
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            ++start;
            --end;
        }
    }

    public static void main(String[] args) {
        ReverseWordsInAStringIII_557 r=new ReverseWordsInAStringIII_557();
        System.out.println(r.reverseWords(" Let's take "));
    }
}
