package ArrayAndString;

import java.util.ArrayList;
import java.util.List;

/*
螺旋矩阵
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
示例 2:

输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix_54 {
    public List<Integer> spiralOrder(int[][] matrix){
        List list=new ArrayList();
        if(matrix.length==0)
            return list;//若数组为空，直接返回答案
        //定义上下左右边界
        int up=0;
        int down=matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;
        while(true){
            for(int i=left;i<=right;i++)//向左移动到最右
                list.add(matrix[up][i]);
            if(++up>down)//重新设定上边界，若上边界大于下边界，则遍历完成
                break;
            for(int i=up;i<=down;i++)//向下
                list.add(matrix[i][right]);
            if(--right<left)//重新设定有边界
                break;
            for(int i=right;i>=left;--i)//向左
                list.add(matrix[down][i]);
            if(--down<up)//重新设定下边界
                break;
            for(int i=down;i>=up;--i)//向上
                list.add(matrix[i][left]);
            if(++left>right)//重新设定左边界
                break;
        }
        return list;
    }

    public static void main(String[] args) {
        SpiralMatrix_54 s=new SpiralMatrix_54();
        System.out.println(s.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
}
