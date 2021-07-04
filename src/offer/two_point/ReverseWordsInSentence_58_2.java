package offer.two_point;

/**
 * @Classname ReverseWordsInSentence_58_2
 * @Description 左旋转字符串。将字符串前面的给定的n个字符转移到字符串的尾部。
 *              例如：输入"abcdefg" 和2,输出：cdefgab    思路和58_1是一样的
 * @Author likui
 * @Date 2021/7/3 21:58
 **/
public class ReverseWordsInSentence_58_2 {
    public String leftRotateString(String str, int n){
        if(n>=str.length()){
            return str;
        }
        char[] chars = str.toCharArray();
        //根据给定的n，将字符串分为两部分
        //先翻转前半部分
        reverse(chars,0,n-1);
        //再翻转后半部分
        reverse(chars,n,chars.length-1);
        //最后翻转整个字符串
        reverse(chars,0,chars.length-1);
        return new String(chars);
    }

    private void reverse(char[] chars,int i,int j){
        while (i<j){
            swap(chars,i++,j--);
        }
    }

    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }

    public static void main(String[] args) {
        ReverseWordsInSentence_58_2 r=new ReverseWordsInSentence_58_2();
        String str="abcdefg";
        System.out.println(r.leftRotateString(str,2));
    }
}
