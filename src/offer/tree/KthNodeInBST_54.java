package offer.tree;

/**
 * @Classname KthNodeInBST_54
 * @Description 二叉树的第K个节点
 * @Author likui
 * @Date 2021/6/24 23:07
 **/
public class KthNodeInBST_54 {
    //记录当前元素的排名
    private int pos;

    //记录结果
    private TreeNode target;
    public TreeNode kthNode(TreeNode root,int k){
        inOrder(root,k);
        return target;
    }

    private void inOrder(TreeNode node,int k){
        //pos>=k，避免已经找到节点值还要继续遍历的情况
        if(node==null||pos>=k){
            return;
        }
        inOrder(node.left,k);
        pos++;
        if(pos==k){
           target=node;
        }
        inOrder(node.right,k);
    }
}
