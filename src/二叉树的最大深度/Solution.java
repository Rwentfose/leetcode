package 二叉树的最大深度;

import common.TreeNode;

class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int i = maxDepth(root.left);
        int j = maxDepth(root.right);

        return Math.max(i, j) + 1;
    }

    public static void main(String[] args) {
        // 测试代码
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(15);
        root.right.right.right.right = new TreeNode(100);
        System.out.println(new Solution().maxDepth(root)); // 输出应为3
    }
}