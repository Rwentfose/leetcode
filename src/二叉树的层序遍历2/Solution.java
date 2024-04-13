package 二叉树的层序遍历2;

import java.util.*;

import common.TreeNode;
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
         if(root == null){
             return res;
         }
        Deque<TreeNode> queue= new LinkedList<>();
         queue.offer(root);
         while (!queue.isEmpty()){
             int size = queue.size();
             List<Integer> list = new ArrayList<>();
             while (size > 0){
                 TreeNode node = queue.poll();
                 list.add(node.val);
                 if(node.left != null){
                     queue.offer(node.left);
                 }
                 if (node.right != null){
                     queue.offer(node.right);
                 }
                 size--;
             }
             res.add(list);
         }
        Collections.reverse(res);
         return res;
    }
}