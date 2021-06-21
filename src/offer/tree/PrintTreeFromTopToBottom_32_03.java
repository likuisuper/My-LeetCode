package offer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * @Classname PrintTreeFromTopToBottom_32_03
 * @Description 之字形打印二叉树：第一行从左到右，第二行从右到左，第三行从左到右，第四行从右到左
 * @Author likui
 * @Date 2021/6/21 22:46
 **/
public class PrintTreeFromTopToBottom_32_03 {
    public ArrayList<ArrayList<Integer>> print(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        ArrayList<ArrayList<Integer>> ret=new ArrayList<>();
        if(root==null){
            return ret;
        }
        //定义一个变量来判断是奇数层还是偶数层
        int depth=0;
        queue.offer(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> list=new ArrayList<>();
            int count = queue.size();
            while (count-->0){
                TreeNode node = queue.poll();
                if(node==null){
                    continue;
                }
                //如果是偶数层，那么子节点的输出顺序是从左到右，顺序输出
                if(depth%2==0){
                    list.add(node.val);
                }else {
                    //奇数层，那么就是从右到左，逆序输出
                    list.add(0,node.val);
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            depth++;
            ret.add(list);
        }
        return ret;
    }
}
