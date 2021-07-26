package tree;

/**
 * @Classname TreeNode
 * @Description TODO
 * @Author likui
 * @Date 2021/7/25 21:06
 **/
public class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;
    TreeNode next;
    TreeNode(Integer val){
        this.val=val;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TreeNode{");
        sb.append("val=").append(val);
        sb.append(", left=").append(left);
        sb.append(", right=").append(right);
        sb.append(", next=").append(next);
        sb.append('}');
        return sb.toString();
    }
}
