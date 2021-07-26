package tree;


/**
 * @Classname ConstructBinaryTree_07
 * @Description 后序遍历+中序遍历构建二叉树
 * @Author likui
 * @Date 2021/5/2 21:33
 **/
public class ConstructBinaryTree_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    /**
     * 首先确定根节点，然后将前序和中序遍历数组分成两半，递归构建左右子树
     * @param inorder 中序遍历数组
     * @param inStart 中序遍历数组起始索引
     * @param inEnd 中序遍历数组终止索引
     * @param postorder 后序遍历数组
     * @param postStart 后序遍历数组起始索引
     * @param postEnd 后序遍历数组终止索引
     * @return
     */
    private TreeNode build(int[] inorder,int inStart,int inEnd,
                           int[] postorder,int postStart,int postEnd){
        if(inStart>inEnd){
            return null;
        }
        //后序遍历的最后一个节点就是根节点
        int rootVal=postorder[postEnd];
        TreeNode root=new TreeNode(rootVal);
        //获取根节点在中序遍历数组中的索引
        int index=0;
        for (int i = inStart; i <= inEnd; i++) {
            if(inorder[i]==rootVal){
                index=i;
                break;
            }
        }
        //递归构建左右子树
        //通过左子树的节点数找到前序遍历左右数组对应的起始索引和终止索引
        int leftSize=index-inStart;
        //注意postend不包含postStart+leftsize。和115题区分开
        root.left=build(inorder,inStart,index-1,postorder,postStart,postStart+leftSize-1);
        //后序遍历的终止索引是根节点即最后一个节点的前一个节点。poststart从poststart+leftsize开始
        root.right=build(inorder,index+1,inEnd,postorder,postStart+leftSize,postEnd-1);
        return root;
    }
}
