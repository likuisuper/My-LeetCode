package offer.tree;

/**
 * @Classname NextNodeInBinaryTrees_08
 * @Description 二叉树的下一个节点。分3种情况
 *              1.该节点的右子树不为空，那么它的下一个节点就是右子树的最左节点
 *              2.该节点的右子树为空，并且不是它父节点的右节点，那么它的下一个节点就是它的父节点
 *              3.当前节点没有右子树，并且是它父节点的右节点，那么需要沿着指向父节点的指针一直向上遍历，
 *              直到找到一个是它父节点的左子节点的节点，找到的这个节点的父节点就是要找的下一个节点
 * @Author likui
 * @Date 2021/5/25 20:57
 **/
public class NextNodeInBinaryTrees_08 {
    private int val;
    NextNodeInBinaryTrees_08 left=null;
    NextNodeInBinaryTrees_08 right=null;
    //指向父节点的指针
    NextNodeInBinaryTrees_08 pNext =null;

    public NextNodeInBinaryTrees_08(int val){
        this.val=val;
    }

    public static void main(String[] args) {
        
    }

    public static NextNodeInBinaryTrees_08 getNext(NextNodeInBinaryTrees_08 pNode){
        //第1种情况
        if(pNode.right!=null) {
            NextNodeInBinaryTrees_08 node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }else {
            while (pNode.pNext !=null){
                //获取父节点
                NextNodeInBinaryTrees_08 parent = pNode.pNext;
                //第2种情况
                if(parent.left==pNode)
                    return parent;
                //第3种情况，将它转换为第2种情况
                pNode=pNode.pNext;
            }
        }
        return null;
    }
}
