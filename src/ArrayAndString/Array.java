package ArrayAndString;


import java.util.Arrays;

//数组简介
public class Array {
    public static void main(String[] args){
        int[] a0=new int[5];
        int[] a1={1,2,3};
        System.out.println("the size of a1 is:"+a1.length);
        System.out.println("the first element is:"+a1[0]);
        for(int i=0;i<a1.length;i++){
            System.out.println(a1[i]);
        }
        System.out.println();
        for(int item:a1){
            System.out.println(item);
        }
        System.out.println();
        a1[0]=4;
        Arrays.sort(a1);
        for(int item:a1){
            System.out.println(item);
        }
    }
}
