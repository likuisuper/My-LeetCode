package offer.tree;

/**
 * @Classname CommonParentInTree_68
 * @Description 树中两个节点的公共祖先
 * @Author likui
 * @Date 2021/6/25 21:12
 **/
public class CommonParentInTree_68 {
    /**
     * 第一种情况是该树是二叉搜索树
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return root;
        }
        //从根节点开始遍历，如果当前节点的值大于输入的两个节点值，那么最低的共同节点一定在当前节点的左子树
        //如果当前节点的值小于输入的两个节点值，那么最低的共同节点一定在当前节点的右子树
        if(root.val>p.val&&root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(root.val<p.val&&root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }

    /**
     * 第二种情况是该树是一棵普通的树
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root,TreeNode p,TreeNode q){
        if(root==null||root==p||root==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        //如果两个节点分别在两个子树中，说明根节点就是最低公共祖先
        return left==null?right:right==null?left:root;
    }
}
