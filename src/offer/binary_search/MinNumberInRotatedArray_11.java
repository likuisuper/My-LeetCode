package offer.binary_search;

/**
 * @Classname MinNumberInRotatedArray_11
 * @Description 旋转数组的最小数字。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素
 *              比如{3,4,5,1,2}是{1,2,3,4,5}的一个旋转，该数组的最小元素是1
 * @Author likui
 * @Date 2021/7/8 21:14
 **/
public class MinNumberInRotatedArray_11 {
    public int minNumberInRotateArray(int [] array){
        if(array==null||array.length<=0){
            return 0;
        }
        //二分查找减小搜索范围
        int index1=0;
        int index2=array.length-1;
        //中间元素的下标，为什么初始化为index1呢？因为有个特例：
        //如果把排序数组的第0个元素搬到最后面，即排序数组本身，也是可以的
        //那么此时就可以直接返回
        int minIndex=index1;
        while (array[index1]>=array[index2]){
            //如果两个指针相邻，说明第二个指针指向的就是最小的元素
            if(index2-index1==1){
                minIndex=index2;
                break;
            }
            minIndex=(index1+index2)/2;

            //特殊情况，当输入的数组是{1,0,1,1,1}和{1,1,1,0,1}
            //此时index1，index2，minIndex都是1，无法通过移动指针来缩小范围，只能顺序查找
            if(array[index1]==array[index2]&&array[minIndex]==array[index1])
                return minInOrder(array,index1,index2);

            if(array[index1]<=array[minIndex])
                //根据旋转数组的性质，说明最小的元素还在中间数的后面
                index1=minIndex;
            else if(array[index2]>=array[minIndex])
                //同理，说明最小的元素在第二个指针前面
                index2=minIndex;
        }
        return array[minIndex];
    }

    private int minInOrder(int[] array,int index1,int index2){
        int result=array[index1];
        //i从index1+1开始，因为不会出现index1最小的情况，不然上面的while循环都不会走
        for (int i = index1+1; i <= index2; i++) {
            if(result>array[i]){
                result=array[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinNumberInRotatedArray_11 m=new MinNumberInRotatedArray_11();
        System.out.println(m.minNumberInRotateArray(new int[]{1, 1, 1,0,1}));
    }
}
