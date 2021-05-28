package offer.tree;

/**
 * @Classname MirrorOfBinaryTree_27
 * @Description 二叉树的镜像，思路：
 *              先前序遍历这个树的每个节点，如果这个节点有子节点，那么交换两个子节点，
 *              当交换所有的非叶节点的左右子节点后，就得到了树的镜像
 * @Author likui
 * @Date 2021/5/27 20:51
 **/
public class MirrorOfBinaryTree_27 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(null);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(null);
        TreeNode node5=new TreeNode(4);
        root.left=node1;
        root.right=node3;
        node1.left=node2;
        node1.right=node4;
        node3.left=node5;
        System.out.println(new MirrorOfBinaryTree_27().mirror(root));

    }
    public TreeNode mirror(TreeNode node){
        if(node==null)
            return null;
        if(node.left==null&&node.right==null)
            return node;
        TreeNode tmp=node.left;
        node.left=node.right;
        node.right=tmp;
        //让左右子节点继续翻转它们的子节点
        mirror(node.left);
        mirror(node.right);
        return node;
    }


}
