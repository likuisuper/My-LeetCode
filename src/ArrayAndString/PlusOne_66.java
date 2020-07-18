package ArrayAndString;

import java.util.Arrays;

/*
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
 */
public class PlusOne_66 {
    public int[] plusOne(int[] digits){
        /*
        只要+1求余数，余数不等于0，说明没有进位，直接返回。
        如果余数等于0，说明有进位，遍历前一个数字，加1再求余数，以此循环。
        如果for循环都遍历完了，说明最高位也有进位，则重新建立一个数组，初始化为0，将第一位设置为1就可以了，
        因为，99、999之类的数字加一为100、1000
         */
        for(int i=digits.length-1;i>=0;i--){
            digits[i]++;
            digits[i]%=10;
            if(digits[i]!=0)
                return digits;
        }
        digits=new int[digits.length+1];
        digits[0]=1;
        return digits;
    }

    public static void main(String[] args) {
        PlusOne_66 p=new PlusOne_66();
        System.out.print(Arrays.toString(p.plusOne(new int[]{9,9,9,9})));
    }
}
