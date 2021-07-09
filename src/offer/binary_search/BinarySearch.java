package offer.binary_search;

/**
 * @Classname BinarySearch
 * @Description 二分搜索的多种写法，以及查找左右侧边界的写法，比如[1,2,2,4]，target=2，那么它的左侧区间就是索引1，右侧区间就是索引2
 *              总结：一、如果两端都是闭区间，那么while循环条件就是left<right，并且要考虑数组越界的情况
 *              如果是寻找左侧区间，那么要考虑left超过数组大小和target不在数组中的情况，如果是寻找右侧区间，那么要考虑right小于数字长度和target不在数组中的情况
 *              二、如果是左闭右开区间，那么要考虑right的范围，它是开区间，所以应该是从middle开始，同样考虑数组越界情况
 *              一般寻找左右侧区间都是使用左闭右开，但是使用两端都是开区间更好记。
 *              相关题目：剑指offer53:数字在排序数组中出现的次数
 * @Author likui
 * @Date 2021/7/9 10:26
 **/
public class BinarySearch {
    /**
     * 正常的二分搜索
     * 第一种：右指针是数组的长度-1
     * 第二种：右指针是数组的长度，那么只要将while循环的条件改为left<right即可
     * @param array
     * @param target
     * @return
     */
    public int binarySearch1(int[] array,int target){
        if(array==null||array.length==0){
            return -1;
        }
        //也就是搜索区间为[0,array.length-1]，左闭右开
        int left=0;
        int right=array.length-1;
        //所以这里循环的条件是 left<=right
        //当left=right+1时退出，说明区间为空，没有找到
        while (left<=right){
            //和 (left+right)/2是一样的，但是这种写法可以防止当left和right很大（超过int范围）的时候出现溢出
            int middle=left+(right-left)/2;
            if(array[middle]==target)
                return middle;
            else if(array[middle]<target){
                left=middle+1;
            }else if(array[middle]>target){
                right=middle-1;
            }
        }
        return -1;
    }

    /**
     * 寻找左侧区间的二分查找
     * 第一种：right等于数组长度-1
     * @param array
     * @param target
     * @return
     */
    public int leftBound1(int[] array,int target){
        if(array==null||array.length==0){
            return -1;
        }
        //左闭右闭区间
        int left=0;
        int right=array.length-1;
        while (left<=right){
            int middle=left+(right-left)/2;
            if(array[middle]<target){
                //搜索区间[middle+1,right]
                left=middle+1;
            }else if(array[middle]>target){
                //搜索区间[left,middle-1]
                right=middle-1;
            }else if(array[middle]==target){
                //缩小左侧边界的范围
                right=middle-1;
            }
        }
        //注意，当循环结束后，left=right+1=array.length
        //如果一个target比数组中所有的数都要大，那么最后left=right+1，超过了数组大小，会出现越界问题，比如[1,2,3,4,5]，target=6
        if(left>=array.length||array[left]!=target)
            return -1;
        //因为是寻找target的左侧边界，所以这里返回left，这也是为什么不用处理当target比数组中所有数都要小的情况
        //当出现这种情况，right就会一直被减到-1，但是我们返回的是left，也就是0
        return left;
    }

    /**
     * 寻找左侧区间的二分查找
     * 第二种情况：right=数组长度
     * @param array
     * @param target
     * @return
     */
    public int leftBound2(int[] array,int target){
        if(array==null||array.length==0){
            return -1;
        }
        //左闭右开区间
        int left=0;
        int right=array.length;
        while (left<right){
            int middle=left+(right-left)/2;
            if(array[middle]<target){
                left=middle+1;
            }else if(array[middle]>target){
                //注意，这里是middle，因为右区间是开的，如果这里是middle-1的话，那么middle就漏了
                //当array[middle]被检测后，下一步的搜索区间应该去掉middle
                right=middle;
            }else if(array[middle]==target){
                //缩小左侧边界的范围
                right=middle;
            }
        }
        //注意，当循环结束后，left=right
        //如果一个target比数组中所有的数都要大，那么最后left=right，超过了数组大小，会出现越界问题，比如[1,2,3,4,5]，target=6
        if(left==array.length||array[left]!=target)
            return -1;
        return left;
    }

    /**
     * 寻找右侧区间的二分查找
     * 1、两端都是闭区间
     * @param array
     * @param target
     * @return
     */
    public int rightBound1(int[] array,int target){
        if(array==null||array.length==0){
            return -1;
        }
        //左闭右闭区间
        int left=0;
        int right=array.length-1;
        while (left<=right){
            int middle=left+(right-left)/2;
            if(array[middle]<target){
                left=middle+1;
            }else if(array[middle]>target){
                //注意，这里是middle+1，因为右区间是闭的
                right=middle-1;
            }else if(array[middle]==target){
                //缩小右侧边界的范围，因为左区间是闭的，所以这里从middle+1开始
                left=middle+1;
            }
        }
        //注意，当循环结束后，left=right+1
        //如果一个target比数组中所有的数都要小，那么最后right=left-1，不在数组中，会出现越界问题，比如[1,2,3,4,5]，target=0
        //注意第二个判断条件，当一个数不在数组中，比如[1,2,3,4,5],target=6，如果不加这个条件，那么就会返回right=4
        if(right<0||array[right]!=target)
            return -1;
        return right;
    }

    /**
     * 左闭右开区间
     * @param array
     * @param target
     * @return
     */
    public int rightBound2(int[] array,int target){
        if(array==null||array.length==0){
            return -1;
        }
        //左闭右开区间
        int left=0;
        int right=array.length;
        while (left<right){
            int middle=left+(right-left)/2;
            if(array[middle]<target){
                left=middle+1;
            }else if(array[middle]>target){
                //注意，这里是middle，因为右区间是开的，如果这里是middle-1的话，那么middle就漏了
                //当array[middle]被检测后，下一步的搜索区间应该去掉middle
                right=middle;
            }else if(array[middle]==target){
                //缩小右侧边界的范围
                left=middle+1;
            }
        }
        //注意，当循环结束后，left=right
        //如果一个target比数组中所有的数都要大，那么最后left=right，超过了数组大小，会出现越界问题，比如[1,2,3,4,5]，target=6
        //这里返回left-1（right-1也是一样），为什么？
        //因为left的更新必须是middle+1，当循环结束后，array[left]一定不等于target，而array[left-1]可能是target
        if(right==0||array[left-1]!=target)
            return -1;
        return left-1;
    }

    public static void main(String[] args) {
        BinarySearch b=new BinarySearch();
//        int[] array={1,2,2,4};
        int[] array={1,2,3,4,5};
        System.out.println(b.rightBound2(array, 6));
    }
}
