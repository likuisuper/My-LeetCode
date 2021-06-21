package offer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname PrintTreeFromTopToBottom_32_02
 * @Description 分行打印二叉树（层次遍历），比如
 *              1
 *              2   3
 *              4   5   6   7
 * @Author likui
 * @Date 2021/6/21 21:13
 **/
public class PrintTreeFromTopToBottom_32_02 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode root){
        //可以使用ArrayList来代替队列
//        ArrayList<TreeNode> queue=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        ArrayList<ArrayList<Integer>> ret=new ArrayList<>();
        if(root==null){
            return ret;
        }
        //对应ArrayList的add
        queue.offer(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> list=new ArrayList<>();
            int count = queue.size();
            while (count-->0){
                //对应ArrayList的remove(0)操作
                TreeNode node = queue.poll();
                if(node==null){
                    continue;
                }
                list.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if(!list.isEmpty()) {
                ret.add(list);
            }
        }
        return ret;
    }
}
