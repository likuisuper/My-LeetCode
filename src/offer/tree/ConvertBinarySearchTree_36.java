package offer.tree;

/**
 * @Classname ConvertBinarySearchTree
 * @Description 输入一棵二叉搜索树，将它转换成一个排序的双向链表
 *              输入: {10,6,14,4,8,12,16}
 *              输出:From left to right are:4,6,8,10,12,14,16;From right to left are:16,14,12,10,8,6,4;
 * @Author likui
 * @Date 2021/6/23 21:27
 **/
public class ConvertBinarySearchTree_36 {
    //声明一个前驱节点，始终指向当前节点的前一个节点
    private TreeNode pre;
    //声明一个头节点
    private TreeNode head;

    public TreeNode Convert(TreeNode root){
        inorder(root);
        return head;
    }

    private void inorder(TreeNode node){
        if(node==null){
            return;
        }
        //中序遍历
        //先遍历左子树
        inorder(node.left);
        node.left=pre;
        //如果前驱节点不为空，那么将右节点指向当前节点
        if(pre!=null){
            pre.right=node;
        }
        //当前节点成为前驱节点
        pre=node;
        if(head==null){
            head=node;
        }
        //遍历右子树
        inorder(node.right);
    }
}
