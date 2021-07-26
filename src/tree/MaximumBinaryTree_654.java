package tree;

/**
 * @Classname MaximumBinaryTree_654
 * @Description 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 *              二叉树的根是数组 nums 中的最大元素。
 *              左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 *              右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 *              返回有给定数组 nums 构建的 最大二叉树 。
 * @Author likui
 * @Date 2021/7/25 23:24
 **/
public class MaximumBinaryTree_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums==null||nums.length==0)
            return null;
        return build(nums,0,nums.length-1);
    }

    private TreeNode build(int[] nums,int low,int high){
        if(low>high)
            return null;
        //首先需要构造root节点，即找到数组中的最大元素
        int maxValue=Integer.MIN_VALUE;
        int index=-1;
        for (int i = low; i <= high; i++) {
            if(nums[i]>maxValue){
                maxValue=nums[i];
                index=i;
            }
        }
        TreeNode root=new TreeNode(maxValue);
        root.left = build(nums, low, index - 1);
        root.right = build(nums, index + 1, high);
        return root;
    }
}
