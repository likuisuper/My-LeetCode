package offer.tree;

/**
 * @Classname TreeDepth_55_02
 * @Description 输入一棵二叉树的根节点，判断该树是不是平衡二叉树
 * @Author likui
 * @Date 2021/6/24 23:48
 **/
public class TreeDepth_55_02 {
    //初始化为true，便于height方法中进行判断
    private boolean isBalance=true;

    public boolean isBalanced(TreeNode root){
        height(root);
        return isBalance;
    }

    private int height(TreeNode node){
        if(node==null||!isBalance){
            return 0;
        }
        //采用后序遍历确保一个节点只遍历一次而不会重复遍历多次
        //遍历左子树
        int left=height(node.left);
        //遍历右字树
        int right=height(node.right);
        //左右子树高度相差1就是平衡二叉树
        if(Math.abs(left-right)>1){
            isBalance=false;
        }
        return 1+Math.max(left,right);
    }
}
