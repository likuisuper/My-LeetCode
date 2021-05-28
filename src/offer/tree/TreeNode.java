package offer.tree;

/**
 * @Classname TreeNode
 * @Description 树结构
 * @Author likui
 * @Date 2021/5/28 20:49
 **/
public class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;
    TreeNode(Integer val){
        this.val=val;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TreeNode{");
        sb.append("val=").append(val);
        sb.append(", left=").append(left);
        sb.append(", right=").append(right);
        sb.append('}');
        return sb.toString();
    }
}
