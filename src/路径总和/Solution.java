package 路径总和;

import common.TreeNode;

import java.util.Stack;

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        Stack<Object> stack = new Stack<>();
          if (root == null){
              return false;
          }
        stack.push(root);
        stack.push(root.val);
          while (!stack.isEmpty()){
              int sum = (int) stack.pop();
              TreeNode node = (TreeNode) stack.pop();
              if (node.left == null && node.right == null && sum == targetSum){
                  return true;
              }
              if (node.left != null){
                  stack.push(node.left);
                  stack.push(sum + node.left.val);
              }
              if (node.right != null){
                  stack.push(node.right);
                  stack.push(sum + node.right.val);;
              }
          }
          return  false;
    }

    public static void main(String[] args) {
        new Solution().hasPathSum(null, 0);
    }
}