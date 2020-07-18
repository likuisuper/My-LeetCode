package ArrayAndString;

/*
给你两个二进制字符串，返回它们的和（用二进制表示）。
输入为 非空 字符串且只包含数字 1 和 0。

示例 1:

输入: a = "11", b = "1"
输出: "100"
示例 2:

输入: a = "1010", b = "1011"
输出: "10101"
 
提示：

每个字符串仅由字符 '0' 或 '1' 组成。
1 <= a.length, b.length <= 10^4
字符串如果不是 "0" ，就都不含前导零。
 */
public class AddBinary_67 {
    public String addBinary(String a,String b){
        StringBuilder sb=new StringBuilder();
        int ca=0;
        for(int i=a.length()-1,j=b.length()-1;i>=0||j>=0;i--,j--){
            int sum=ca;
            sum+=(i>=0?a.charAt(i)-'0':0);//获取字符串a对应的每一位值，当i<0则将其当做0处理，否则获取其值，两个字符相减，起其实就是对应的ASCII相减
            sum+=(j>=0?b.charAt(j)-'0':0);//j>=0的含义是有可能两个数字的长度不一样，<0就当成0来处理，否则取其值
            sb.append(sum%2);
            ca=sum/2;//计算进位
        }
        sb.append(ca==1?ca:"");//这一步表示是不是最后还有进位，比如1+1 = 10，10前面的1就是最后留存的进位，需要将其放进去
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary_67 a=new AddBinary_67();
        System.out.println(a.addBinary("11","11"));
    }
}
