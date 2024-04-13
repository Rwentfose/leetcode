package 左叶子之和;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    //广度优先搜索
    public int sumOfLeftLeaves(TreeNode root) {
       if (root.left ==null && root.right == null){
           return 0;
       }
        Deque<TreeNode> deque = new LinkedList<>();
       int count = 0;
       deque.offer(root);
       while (!deque.isEmpty()){
           TreeNode node = deque.poll();
           if (node.left != null && node.left.left == null && node.left.right == null)
               count = count + node.left.val;
           if (node.left != null){
               deque.offer(node.left);
           }
           if (node.right != null){
               deque.offer(node.right);
           }
       }
       return count;
    }
   //深度优先搜索
    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null){
            return 0;
        }
       if (root.left==null && root.right == null){
           return 0;
       }
       if (root.left!=null&& root.left.left == null && root.left.right == null){
           return root.left.val + sumOfLeftLeaves1(root.right);
       }
       //左节点和右节点
       return sumOfLeftLeaves1(root.left) + sumOfLeftLeaves1(root.right);
    }

    public static void main(String[] args) {
        // 测试代码
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().sumOfLeftLeaves1(root));
    }
}