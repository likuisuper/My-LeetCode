package ArrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class dynamic_array {
    public static void main(String[] args) {
        //1.初始化
        List<Integer> v0=new ArrayList<>();
        List<Integer> v1;
        // 2. cast an array to a vector
        Integer[] a={0,1,2,3,4};
        v1=new ArrayList<>(Arrays.asList(a));
        //3.make a copy
        List<Integer> v2=v1;
        List<Integer> v3=new ArrayList<>(v1);
        //get length
        System.out.println("the size of v1 is:"+v1.size());
        //iterate the vector
        for(int i=0;i<v1.size();i++){
            System.out.println(" "+v1.get(i));
        }
        System.out.println();
        for(int item:v1){
            System.out.println(" "+item);
        }
        System.out.println();
        //modify element
        v2.set(0,5);//v2实际上会改变v1
        System.out.println("the first element of v1 is:"+v1.get(0));
        v3.set(0,-1);
        System.out.println("the first element of v1 is:"+v1.get(0));
        //sort
        Collections.sort(v1);
        for(int item:v1){
            System.out.println(item);
        }
        //add new element at the end of the vector
        v1.add(-1);
        for(int item:v1){
            System.out.println(item);
        }
        v1.add(1,6);
        //delete the last element
        v1.remove(v1.size()-1);
        for(int item:v1){
            System.out.println(item);
        }
    }
}
