package ArrayAndString;

import java.util.ArrayList;
import java.util.List;

/*
杨辉三角||

给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。

在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 3
输出: [1,3,3,1]
进阶：

你可以优化你的算法到 O(k) 空间复杂度吗？

题目解析
这道题目的难点与思考点在于题目有额外限制条件，程序只能使用 O(k) 的额外空间，因此无法通过累加的方式将每一行都输出打印。
这里依旧使用杨辉三角的规律，很隐藏的规律：对于杨辉三角的同一行，第 ( i + 1) 项是第 i 项的 ( k - i ) /( i + 1 ) 倍。
比如：

第 k 索引行的第 0 项：1
第 k 索引行的第 1 项：1 * k
第 k 索引行的第 2 项：1 * k * ( k - 1) / 2
第 k 索引行的第 3 项：[1 * k * ( k - 1) / 2 ] * ( k - 2 ) / 3
 */
public class PascalsTriangle_119 {
    public List<Integer> getRow(int rowIndex){
        List<Integer> list=new ArrayList<>();
        long index=1;
        for(int i=0;i<=rowIndex;++i){
            list.add((int)index);
            index=index*(rowIndex-i)/(i+1);
        }
        return list;
    }

    public static void main(String[] args) {
        PascalsTriangle_119 p=new PascalsTriangle_119();
        System.out.println(p.getRow(3));
    }
}
