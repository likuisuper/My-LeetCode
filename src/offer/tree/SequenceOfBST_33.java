package offer.tree;

/**
 * @Classname SequenceOfBST
 * @Description 二叉搜索树的后序遍历序列
 * @Author likui
 * @Date 2021/6/22 21:30
 **/
public class SequenceOfBST_33 {
    public boolean VerifySequenceOfBST(int[] sequence){
        return verify(sequence,0,sequence.length-1);
    }

    private boolean verify(int[] sequence, int i, int j) {
        if(i>=j){
            return true;
        }
        int p=i;
        //划分左右子树和根节点
        while (sequence[p]<sequence[j])
            p++;
        //m用来记录第一个大于根节点的节点值
        int m=p;
        while (sequence[p]>sequence[j])
            p++;
        //p==j判断此树是否正确，(i,m-1)判断左子树是否正确，(m,j-1)判断右子树是否正确
        return p==j&&verify(sequence,i,m-1)&&verify(sequence,m,j-1);
    }
}
