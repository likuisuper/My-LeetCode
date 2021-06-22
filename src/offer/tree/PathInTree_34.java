package offer.tree;

import java.util.ArrayList;

/**
 * @Classname PathInTree_34
 * @Description 二叉树中和为某一值的路径
 * @Author likui
 * @Date 2021/6/22 22:29
 **/
public class PathInTree_34 {
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectedSum) {
        backtracking(root, expectedSum, new ArrayList<>());
        return ret;
    }

    private void backtracking(TreeNode root, int expectedSum, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        //将当前节点放入路径中
        path.add(root.val);
        //长度-当前访问的节点值
        expectedSum -= root.val;
        //如果是叶子节点，并且路径上节点值的和等于输入的值，打印节点
        if (expectedSum == 0 && root.left == null && root.right == null) {
            ret.add(new ArrayList<>(path));
        } else {
            //递归遍历左节点
            backtracking(root.left, expectedSum, path);
            //递归遍历右节点
            backtracking(root.right, expectedSum, path);
        }
        //返回父节点之前，在路径上删除当前节点
        path.remove(path.size() - 1);
    }
}
