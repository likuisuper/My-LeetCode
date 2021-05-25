package offer.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname ConstructBinaryTree_07
 * @Description 重建二叉树
 * @Author likui
 * @Date 2021/5/2 21:33
 **/
public class ConstructBinaryTree_07 {
    int val;
    ConstructBinaryTree_07 left;
    ConstructBinaryTree_07 right;
    ConstructBinaryTree_07(int val){
        this.val=val;
    }

    //缓存中序遍历数组每个值对应的索引
    private static Map<Integer,Integer> map=new HashMap<>();

    public static void main(String[] args) {
        int[] preorder={3,9,20,15,7};
        int[] inorder={9,3,15,20,7};
        System.out.println(reBuildTree(preorder, inorder));
    }

    public static ConstructBinaryTree_07 reBuildTree(int[] preorder, int[] inorder){
        if(preorder==null||inorder==null){
            return null;
        }
        //遍历中序遍历数组
        for (int i=0;i<inorder.length;i++) {
            map.put(inorder[i],i);
        }
        return reBuildTree(preorder,0,preorder.length-1,0);
    }

    private static ConstructBinaryTree_07 reBuildTree(int[] preorder, int preLeft, int preRight, int inLeft) {
        if(preLeft>preRight){
            return null;
        }
        ConstructBinaryTree_07 constructBinaryTree07 =new ConstructBinaryTree_07(preorder[preLeft]);
        //获取中序遍历的根节点
        int root = constructBinaryTree07.val;
        //获取中序遍历根节点索引
        int index=map.get(root);
        //左部分长度
        int leftLen=index-inLeft;

        //构建左子树
        constructBinaryTree07.left=reBuildTree(preorder,preLeft+1,preLeft+leftLen,inLeft);
        //构建右子树
        constructBinaryTree07.right=reBuildTree(preorder,preLeft+leftLen+1,preRight,inLeft+leftLen+1);
        return constructBinaryTree07;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Offer07{");
        sb.append("val=").append(val);
        sb.append(", left=").append(left);
        sb.append(", right=").append(right);
        sb.append('}');
        return sb.toString();
    }
}
