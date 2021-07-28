package offer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Classname PrintTreeFromTopToBottom
 * @Description 不分行从上到下打印二叉树（层次遍历），比如：1,2,3,4,5
 * @Author likui
 * @Date 2021/6/21 20:16
 **/
public class PrintTreeFromTopToBottom_32_01 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root){
        //声明一个队列
        Queue<TreeNode> queue=new LinkedList<>();
        //声明一个集合保存返回元素
        ArrayList<Integer> list=new ArrayList<>();
        //将根节点入队
        queue.offer(root);
        while (!queue.isEmpty()){
            //队列长度就是每层的节点数
            int size=queue.size();
            while (size-->0){
                TreeNode node = queue.poll();
                //为空则继续遍历下一个节点
                if(node==null){
                    continue;
                }
                list.add(node.val);
                //将左右节点入队
                queue.offer(root.left);
                queue.offer(root.right);
            }
        }
        return list;
    }

    /**
     * 精简解法。力扣返回的是一个数组
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if(root==null)
            return new int[0];
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        List<Integer> list=new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            list.add(node.val);
            if(node.left!=null)
                queue.offer(node.left);
            if(node.right!=null)
                queue.offer(node.right);
        }
        int[] array=new int[list.size()];
        for(int i=0;i<list.size();i++){
            array[i]=list.get(i);
        }
        return array;
    }
}
