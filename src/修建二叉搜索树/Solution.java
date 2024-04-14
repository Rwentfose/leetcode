package 修建二叉搜索树;

import common.TreeNode;

class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
      if (root == null){
          return null;
      }
      // 修剪右子树
        if (root.val < low){
           return trimBST(root.right,low,high);
        }
        // 修剪左子树
        if (root.val > high){
           return trimBST(root.left,low,high);
        }
        if (root.left != null)
            root.left = trimBST(root.left,low,high);
        if (root.right != null)
            root.right = trimBST(root.right,low,high);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        solution.trimBST(root,2,4);
    }
}