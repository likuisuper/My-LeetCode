package offer.array_matrix;

/**
 * @Classname FindInPartiallySortedMatrix_04
 * @Description 二维数组中的查找
 * @Author likui
 * @Date 2021/6/26 22:34
 **/
public class FindInPartiallySortedMatrix_04 {
    public boolean Find(int target, int [][] array) {
        //如果数组为空或者行为空或者列为空，返回false
        if(array==null||array.length==0||array[0].length==0){
            return false;
        }
        //二维数组的行数就是它的长度，列就是一行的长度
        int rows=array.length,cols=array[0].length;
        //从右上角开始，行和列都是从下标0开始
        int r=0;
        int c=cols-1;
        //注意边界范围
        while (r<=rows-1&&c>=0){
            if(target==array[r][c])
                //找到目标元素返回
                return true;
            if(target>array[r][c]) {
                //二维数组中的一个数，大于它的一定在它下面，所以行+1
                r++;
            }else {
                //小于它的数一定在其左边，所以列-1
                c--;
            }
        }
        return false;
    }
}
