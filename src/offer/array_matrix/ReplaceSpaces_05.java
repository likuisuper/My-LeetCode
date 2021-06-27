package offer.array_matrix;

/**
 * @Classname ReplaceSpaces_05
 * @Description 替换空格
 * @Author likui
 * @Date 2021/6/27 20:21
 **/
public class ReplaceSpaces_05 {

    public String replaceSpace(String str){
        if(str==null)
            return null;
        if(str.contains(" ")){
            return str.replace(" ","%20");
        }
        return str;
    }

    public String replaceSpace2(String str){
        if (str==null||str.length()<=0){
            return "";
        }
        StringBuilder sb=new StringBuilder(str);
        //p1指针指向原来字符串的末尾
        int p1=sb.length()-1;
        for (int i = 0; i <= p1; i++) {
            //遇到空格，填充任意两个字符，因为%20占3个字符，原来的空格已经占了一个
            if(sb.charAt(i)==' ')
                sb.append("  ");
        }
        //p2指针指向替换后字符串的末尾
        int p2=sb.length()-1;
        while (p1>=0&&p2>p1){
            char c = sb.charAt(p1--);
            if(' '==c){
                sb.setCharAt(p2--,'0');
                sb.setCharAt(p2--,'2');
                sb.setCharAt(p2--,'%');
            }else {
                sb.setCharAt(p2--,c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReplaceSpaces_05().replaceSpace2(null));
    }
}
