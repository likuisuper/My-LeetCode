package offer.tree;

/**
 * @Classname SerializeBinaryTrees_37
 * @Description 序列化二叉树和反序列化二叉树
 * @Author likui
 * @Date 2021/6/23 22:47
 **/
public class SerializeBinaryTrees_37 {
    //反序列化字符串
    private String deserializeStr;

    /**
     * 序列化
     * @param root 给定二叉树
     * @return 序列化字符串
     */
    public String serialize(TreeNode root){
        if(root==null){
            //#表示空节点
            return "#";
        }
        //以逗号分隔节点值
        return root.val+","+serialize(root.left)+","+serialize(root.right);
    }

    /**
     * 反序列化
     * @param str 给定字符串
     * @return 反序列化后的二叉树
     */
    public TreeNode deSerialize(String str){
        deserializeStr=str;
        return deSerialize();
    }

    private TreeNode deSerialize(){
        if(deserializeStr.length()==0){
            return null;
        }
        //获取第一个逗号出现的位置
        int index=deserializeStr.indexOf(",");
        //截取逗号前面的字符,node表示节点值
        String node=index==-1?deserializeStr:deserializeStr.substring(0,index);
        //将原来的字符串减去上面截取的字符串
        deserializeStr=index==-1?"":deserializeStr.substring(index+1);
        //如果节点值是#,返回null代表当前节点为空
        if(node.equals("#")){
            return null;
        }
        int val=Integer.valueOf(node);
        TreeNode treeNode=new TreeNode(val);
        //递归构建左子树和右子树
        treeNode.left=deSerialize();
        treeNode.right=deSerialize();
        return treeNode;
    }
}
