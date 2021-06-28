package offer.array_matrix;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname FirstNotRepeatingChar_50
 * @Description 第一个只出现一次的字符。可以从头开始扫描字符串中的每个字符，然后拿这个字符
 *              和后面的字符做比较，但是这个时间复杂度是O(N^2)
 *              采用空间换时间的方式，利用hashmap，key是字符串，value是出现次数
 * @Author likui
 * @Date 2021/6/28 21:15
 **/
public class FirstNotRepeatingChar_50 {
    /**
     * 使用hash的方式
     * @param str
     * @return
     */
    public int firstNotRepeatingChar(String str){
        if(str==null||str.length()<=0){
            return -1;
        }
        Map<Character,Integer> hashMap=new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            //字符以及存在，则次数继续+1，否则默认是0+1
            hashMap.put(c,hashMap.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < str.length(); i++) {
            if(hashMap.get(str.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }

    /**
     * 使用BitSet更节省空间，使用2个比特位就能存储
     * @param str
     * @return
     */
    public static int firstNotRepeatingChar2(String str){
        //ASCII 码只有 128 个字符，传入128，最终会创建一个长度为2的long型数组
        //bs1表示只出现一次
        BitSet bs1=new BitSet(128);
        //bs2表示出现2次以上
        BitSet bs2=new BitSet(128);
        for (char c : str.toCharArray()) {
            //如果bs1中和bs2中都不存在该字符，则放入bs1中
            if(!bs1.get(c)&&!bs2.get(c)){
                bs1.set(c);
            }else if(bs1.get(c)&&!bs2.get(c)){
                //如果bs1中存在，但是bs2中不存在，说明该字符至少出现2次以上，放入bs2中
                bs2.set(c);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            //寻找bs1中存在但bs2中不存在的第一个出现的字符
            if(bs1.get(c)&&!bs2.get(c)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstNotRepeatingChar2("gopl"));
    }
}
