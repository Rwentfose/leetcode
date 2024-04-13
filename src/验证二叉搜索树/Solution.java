package 验证二叉搜索树;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true; // 空树视为有效的二叉搜索树
            }

            Deque<TreeNode> queue = new LinkedList<>();
            Deque<Integer> lowerBounds = new LinkedList<>();
            Deque<Integer> upperBounds = new LinkedList<>();

            queue.offer(root);
            lowerBounds.offer(null);
            upperBounds.offer(null);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                Integer lowerBound = lowerBounds.poll();
                Integer upperBound = upperBounds.poll();

                // 检查节点值是否在合法范围内
                if ((lowerBound != null && node.val <= lowerBound) || (upperBound != null && node.val >= upperBound)) {
                    return false;
                }

                // 处理左子树
                if (node.left != null) {
                    queue.offer(node.left);
                    lowerBounds.offer(lowerBound);
                    upperBounds.offer(node.val);
                }

                // 处理右子树
                if (node.right != null) {
                    queue.offer(node.right);
                    lowerBounds.offer(node.val);
                    upperBounds.offer(upperBound);
                }
            }

            return true; // 所有节点均满足二叉搜索树的性质
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(6);
        treeNode.right.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(7);

        boolean validBST = new Solution().isValidBST(treeNode);
        System.out.println(validBST);


    }
}