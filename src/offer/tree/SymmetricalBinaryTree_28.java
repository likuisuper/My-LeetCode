package offer.tree;

/**
 * @Classname SymmetricalBinaryTree_28
 * @Description 对称的二叉树
 * @Author likui
 * @Date 2021/5/28 20:47
 **/
public class SymmetricalBinaryTree_28 {
    private boolean isSymmetrical(TreeNode root){
        return isSymmetrical(root,root);
    }

    private boolean isSymmetrical(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null)
            return true;
        if(root1==null||root2==null)
            return false;
        //如果两个节点的值不一样则返回false
        if(!root1.val.equals(root2.val))
            return false;
        //递归遍历左右子节点
        return isSymmetrical(root1.left,root2.right)&&isSymmetrical(root1.right,root2.left);
    }
}
