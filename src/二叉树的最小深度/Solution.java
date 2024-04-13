package 二叉树的最小深度;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int minDepth(TreeNode root) {

        if (root == null){
            return 0;
        }
        if(root.left == null){
           return 1 + minDepth(root.right);
        }
        if (root.right == null){
            return 1+ minDepth(root.left);
        }

       return 1 + Math.min(minDepth(root.left),minDepth(root.right));
    }
    public int minDepth1(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        if (root  == null){
            return 0;
        }
        deque.offer(root);
        int depth = 1;
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if(node.left == null && node.right == null){
                    return depth;
                }
                if (node.left != null){
                    deque.offer(node.left);
                }
                if(node.right!= null){
                    deque.offer(node.right);
                }
            }
            depth++;
        }

        return depth;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(15);
        root.right.right.right.right = new TreeNode(100);
        System.out.println(new Solution().minDepth1(root)); // 输出应为3

    }
}