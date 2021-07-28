package offer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

    /**
     * 精简解法。queue从后向前遍历。queue的长度就是当前层节点的个数
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> result=new ArrayList<>();
        if(root!=null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            List<Integer> tmp=new ArrayList<>();
            //从后向前遍历，这样就能将每一层的节点都遍历到
            //不能从前向后，因为poll操作会改变queue的size
            for(int i=queue.size();i>0;i--){
                TreeNode node=queue.poll();
                tmp.add(node.val);
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            result.add(tmp);
        }
        return result;
    }
}
