package offer.binary_search;

/**
 * @Classname NumberOfK_53
 * @Description 在排序数组中查找数字。统计一个数字在排序数组中出现的次数
 * @Author likui
 * @Date 2021/7/8 23:04
 **/
public class NumberOfK_53 {
    public int getNumberOfK(int[] array,int k){
        //得到该数在数组中第一个位置
        int first=leftBound(array,k);
        //该数在数组中最后一次出现的位置可以转换为该数后面的数在数组中出现的第一个位置，利用排序数组的特性
        int last=leftBound(array,k+1);
        //要把左侧区间的二分搜索中的越界情况放在这里来
        return (first==array.length||array[first]!=k)?0:last-first;
    }

    public int leftBound(int [] array , int k) {
        if(array==null||array.length==0){
            return -1;
        }
        //使用左闭右开的搜索区间
        int left=0,right=array.length;
        while (left<right){
            int mid=left+(right-left)/2;
            if(array[mid]>k){
                right=mid;
            }else if(array[mid]<k){
                left=mid+1;
            }else if(array[mid]==k){
                //找到该数在数组中第一次出现的位置，相当于左侧区间的二分查找
                right=mid;
            }
        }
        //不能在这里返回，不然k的后一个数如果不在数组中的话，这里返回的就是0，那么相减就会得到负数
//        if(left==array.length||array[left]!=k)
//            return 0;
        return left;
    }

    public static void main(String[] args) {
        NumberOfK_53 n=new NumberOfK_53();
        System.out.println(n.getNumberOfK(new int[]{1, 2, 2, 2, 3}, 3));
    }
}
