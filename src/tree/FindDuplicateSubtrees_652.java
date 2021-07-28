package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Classname FindDuplicateSubtrees_652
 * @Description 寻找重复的子树
 *              给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *              两棵树重复是指它们具有相同的结构以及相同的结点值。
 * @Author likui
 * @Date 2021/7/27 20:52
 **/
public class FindDuplicateSubtrees_652 {
    //存放序列化二叉树出现的次数。因为题目要求返回重复子树任意一棵根节点
    Map<String,Integer> map=new HashMap<>();
    List<TreeNode> list=new LinkedList<>();

    /**
     * 假设root.val长度为a,left长度为b，right长度为c，那么每个节点序列化都需要a+b+c<=N的时间
     * N个节点就是N^2,即时间复杂度
     * 空间复杂度为O(N^2),map的大小
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return list;
    }

    /**
     * 1、知道以自己为根的子树长什么样
     * 2、知道以其他节点为根的二叉树长什么样
     * @param root
     */
    private String traverse(TreeNode root){
        //#号代替空节点
        if(root==null)
            return "#";
        //由1可知需要后序遍历
        String left = traverse(root.left);
        String right = traverse(root.right);
        //将一棵二叉树序列化，便于比较。节点以逗号分隔
        String subTree=left+","+right+","+root.val;
        Integer count = map.getOrDefault(subTree, 0);
        //多次重复也只会被加入结果集一次
        if(count==1){
            list.add(root);
        }
        //给子树对应的次数+1
        map.put(subTree,count+1);
        return subTree;
    }
}
