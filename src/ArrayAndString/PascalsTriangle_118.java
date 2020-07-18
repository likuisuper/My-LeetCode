package ArrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
杨辉三角

给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。

在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

 */
public class PascalsTriangle_118 {
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> result=new ArrayList<>();
        if(numRows<1)
            return result;
        for(int i=0;i<numRows;++i){//这个i是为了遍历list中的每一项
            //扩容
            List<Integer> list= Arrays.asList(new Integer[i+1]);
            //list的第一个值和最后一个值永远为1
            list.set(0,1);
            list.set(i,1);
            for(int j=1;j<i;++j){//j从1开始，因为第0个索引的值永远为1
                list.set(j,result.get(i-1).get(j-1)+result.get(i-1).get(j));//等于上一行的左右两个数字之和
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        PascalsTriangle_118 p=new PascalsTriangle_118();
        System.out.println(p.generate(8));
    }
}
