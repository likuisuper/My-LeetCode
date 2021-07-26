package tree;

/**
 * @Classname PopulatingNextRightPointers_116
 * @Description 填充每个节点的下一个右侧节点指针
 * @Author likui
 * @Date 2021/7/25 21:07
 **/
public class PopulatingNextRightPointers_116 {
    public TreeNode connect(TreeNode root) {
        if(root==null)
            return null;
        helper(root.left,root.right);
        return root;
    }

    private void helper(TreeNode node1,TreeNode node2){
        if(node1==null||node2==null)
            return;
        //将2个节点相连
        node1.next=node2;
        //连接相同父节点的两个节点
        helper(node1.left,node1.right);
        helper(node2.left,node2.right);
        //连接不同父节点的两个节点
        helper(node1.right,node2.left);
    }
}
