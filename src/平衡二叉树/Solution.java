package 平衡二叉树;

import common.TreeNode;

class Solution {
    public boolean isBalanced(TreeNode root) {
        // 空树也是平衡二叉树// 空树也是平衡二叉树
        if (root == null) {
            return true;
        }
        // 递归计算左右子树的高度，并判断是否平衡
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        //要计算每一个左右子树都要差值小于1，我刚开始就因为只计算了第二层的左右子树差值，所以一直报错
        return  Math.abs(left - right) <= 1 &&isBalanced(root.left) && isBalanced(root.right);
    }
   public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
   }
    public boolean isBalanced1(TreeNode root) {
        // 空树也是平衡二叉树// 空树也是平衡二叉树

        return false;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.left.left.left = new TreeNode(8);

        System.out.println(solution.isBalanced(treeNode));
    }
}