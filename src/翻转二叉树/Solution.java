package 翻转二叉树;

import common.TreeNode;

import java.util.*;

class Solution {
    public TreeNode invertTree(TreeNode root) {
         if(root==null){
             return null;
        }
         Stack<TreeNode> stack = new Stack<>();
         stack.push(root);
         while(!stack.isEmpty()){
             int size = stack.size();
             for (int i = 0; i <size ; i++) {
                 TreeNode pop = stack.pop();
                 TreeNode temp = pop.left;
                 pop.left = pop.right;
                 pop.right = temp;
                 if(pop.left!=null){
                     stack.push(pop.left);
                 }
                 if(pop.right!=null){
                     stack.push(pop.right);
                 }
             }
         }
         return  root;
    }

    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        invertTree1(root.right);
        invertTree1(root.left);
        return root;
    }

}