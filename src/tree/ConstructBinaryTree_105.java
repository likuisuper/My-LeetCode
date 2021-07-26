package tree;


/**
 * @Classname ConstructBinaryTree_07
 * @Description 前序遍历+中序遍历构建二叉树
 * @Author likui
 * @Date 2021/5/2 21:33
 **/
public class ConstructBinaryTree_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    /**
     * 首先确定根节点，然后将前序和中序遍历数组分成两半，递归构建左右子树
     * @param preorder 前序遍历数组
     * @param preStart 前序遍历数组起始索引
     * @param preEnd 前序遍历数组终止索引
     * @param inorder 中序遍历数组
     * @param inStart 中序遍历数组起始索引
     * @param inEnd 中序遍历数组终止索引
     * @return
     */
    private TreeNode build(int[] preorder,int preStart,int preEnd,
                           int[] inorder,int inStart,int inEnd){
        if(preStart>preEnd){
            return null;
        }
        //前序遍历的第一个节点就是根节点
        int rootVal=preorder[preStart];
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
        //注意前序遍历起始索引要跳过根节点也就是第一个节点
        root.left=build(preorder,preStart+1,preStart+leftSize,inorder,inStart,index-1);
        root.right=build(preorder,preStart+leftSize+1,preEnd,inorder,index+1,inEnd);
        return root;
    }
}
