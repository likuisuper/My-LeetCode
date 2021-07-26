package tree;

/**
 * @Classname FlattenBinaryTreeToLinkedList_114
 * @Description 二叉树展开为链表
 * @Author likui
 * @Date 2021/7/25 21:55
 **/
public class FlattenBinaryTreeToLinkedList_114 {
    /**
     * 1、将root的左右子树拉平为链表
     * 2、将root的左子树接到右子树下方，然后将整个左子树作为右子树
     * @param root
     */
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        //后序遍历
        flatten(root.left);
        flatten(root.right);
        //先将当前节点的左右节点信息保存
        TreeNode left=root.left;
        TreeNode right=root.right;
        //将左子树作为右子树
        root.left=null;
        root.right=left;
        //将原来的右子树接到当前右子树的末端
        TreeNode p=root;
        while (p.right!=null){
            p=p.right;
        }
        p.right=right;
    }
}
