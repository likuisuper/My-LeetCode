package offer.tree;

/**
 * @Classname SubstructureInTree_26
 * @Description 树的子结构：给定两棵树A和B，判断B是否是树A的子结构
 *              第一步：首先需要在树A中查找与B树根节点的值一样的值，其实就是树的遍历
 *              第二步：判断树A中上一步找到的根节点的子树是否和B树具有相同的结构
 * @Author likui
 * @Date 2021/5/26 20:34
 **/
public class SubstructureInTree_26 {
    static class TreeNode{
        Integer val;
        TreeNode left;
        TreeNode right;
        public TreeNode(Integer val){
            this.val=val;
        }
    }

    public boolean hasSubTree(TreeNode root1,TreeNode root2){
        if(root1==null||root2==null){
            return false;
        }
        return isSubtreeWithRoot(root1,root2)||hasSubTree(root1.left,root2)||hasSubTree(root1.right,root2);
    }

    public boolean isSubtreeWithRoot(TreeNode root1,TreeNode root2){
        //子结构已经循环完毕，代表全部匹配
        if(root2==null)
            return true;
        if(root1==null)
            return false;
        //如果两棵树没有共同的根节点，那么一棵树肯定不是另一棵树的子结构
        if(root1.val!=root2.val)
            return false;
        //递归遍历左右节点
        return isSubtreeWithRoot(root1.left,root2.left)&&isSubtreeWithRoot(root1.right,root2.right);
    }
}
