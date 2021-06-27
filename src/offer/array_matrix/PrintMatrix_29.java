package offer.array_matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname PrintMatrix_29
 * @Description 顺时针打印矩阵
 * @Author likui
 * @Date 2021/6/27 22:26
 **/
public class PrintMatrix_29 {

    public int[] spiralOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return new int[0];
        }
        int[] array=new int[matrix.length*matrix[0].length];
        //获取行和列
        int r1=0,r2=matrix.length-1;
        int c1=0,c2=matrix[0].length-1;
        int index=0;
        while (r1<=r2&&c1<=c2){
            //上
            for (int i = c1; i <= c2; i++) {
                //第一行行不变，列++
                array[index++]=matrix[r1][i];
            }
            //右，注意此时要排除掉上面已经打印的行
            for (int i = r1+1; i <=r2; i++) {
                //列不变，行++
                array[index++]=matrix[i][c2];
            }
            //下，注意排除掉r1=r2的情况
            if(r1!=r2){
                for (int i = c2-1; i >=c1; i--) {
                    //行不变，列--
                    array[index++]=matrix[r2][i];
                }
            }
            //左，注意排除掉c1=c2的情况
            if(c1!=c2){
                for (int i = r2-1; i >r1 ; i--) {
                    array[index++]=matrix[i][c1];
                }
            }
            r1++;
            c1++;
            r2--;
            c2--;
        }
        return array;
    }


    public List<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list=new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return list;
        }
        //获取行和列
        int r1=0,r2=matrix.length-1;
        int c1=0,c2=matrix[0].length-1;
        while (r1<=r2&&c1<=c2){
            //上
            for (int i = c1; i <= c2; i++) {
                //第一行行不变，列++
                list.add(matrix[r1][i]);
            }
            //右，注意此时要排除掉上面已经打印的行
            for (int i = r1+1; i <=r2; i++) {
                //列不变，行++
                list.add(matrix[i][c2]);
            }
            //下，注意排除掉r1=r2的情况
            if(r1!=r2){
                for (int i = c2-1; i >=c1; i--) {
                    //行不变，列--
                    list.add(matrix[r2][i]);
                }
            }
            //左，注意排除掉c1=c2的情况
            if(c1!=c2){
                for (int i = r2-1; i >r1 ; i--) {
                    list.add(matrix[i][c1]);
                }
            }
            r1++;
            c1++;
            r2--;
            c2--;
        }
        return list;
    }
}
