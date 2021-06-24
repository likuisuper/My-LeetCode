package offer.tree;

/**
 * @Classname TreeDepth_55_01
 * @Description 二叉树的深度
 * @Author likui
 * @Date 2021/6/24 23:35
 **/
public class TreeDepth_55_01 {
    public int treeDepth(TreeNode root){
        return root==null?0:1+Math.max(treeDepth(root.left),treeDepth(root.right));
    }
}
