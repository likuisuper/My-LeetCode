package ArrayAndString;

import java.util.Arrays;

/*
给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。

示例:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

输出:  [1,2,4,7,5,3,6,8,9]

说明:

给定矩阵中的元素总数不会超过 100000 。
 */
public class DiagonalTraverse_498 {
    public int[] findDiagonalOrder(int[][] matrix){
        //考虑边界
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return new int[0];
        }
        //m行,n列
        int m=matrix.length;
        int n=matrix[0].length;
        //用来记录加入到新数组的元素下标
        int count=0;
        //用来保存结果的数组 大小为矩阵元素的个数
        int[] result=new int[m*n];
        for(int i=0;i<m+n-1;i++){//这里的i是遍历的对角线数,x+y=i,即横纵坐标之和为i
            if(i==0||i%2==0){//i为0或者偶数时,沿对角线向上遍历
                //发现规律,x+y=i,找边界
                int x=i<m?i:m-1;
                int y=i-x;
                //开始遍历,x不断递减到0,y不断增加到列n的值
                while (x>=0&&y<n){
                    result[count]=matrix[x][y];
                    x--;
                    y++;
                    count++;
                }
            }else{//沿对角线向下遍历
                int y=i<n?i:n-1;
                int x=i-y;
                //y不断递减到0,x不断增加到行m的值
                while (y>=0&&x<m){
                    result[count]=matrix[x][y];
                    y--;
                    x++;
                    count++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DiagonalTraverse_498 d=new DiagonalTraverse_498();
        System.out.println(Arrays.toString(d.findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}})));
    }

}

