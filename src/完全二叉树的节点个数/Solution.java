package 完全二叉树的节点个数;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int countNodes(TreeNode root) {
      //广度遍历
        Deque<TreeNode> deque = new LinkedList<>();
        int count = 0;
         deque.offer(root);
         if (root == null){
             return count;
         }
         while (!deque.isEmpty()){
             int size = deque.size();
             for (int i = 0; i < size; i++) {
                 TreeNode node = deque.poll();
                 count++;
                 if (node.left != null){
                     deque.offer(node.left);
                 }
                 if (node.right != null){
                     deque.offer(node.right);
                 }
             }
         }
         return count;
    }

    public int countNodes1(TreeNode root) {
        //深度遍历算法
        if (root == null){
            return 0;
        }
        int left = countNodes1(root.left);
        int right = countNodes1(root.right);
        return  left + right + 1;
    }
}