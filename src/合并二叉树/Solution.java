package 合并二叉树;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root1);
        deque.offer(root2);
        if (root1 == null){
            return root2;
        }
        if (root2 == null){
            return root1;
        }
        while (!deque.isEmpty()) {
            TreeNode node1 = deque.poll();
            TreeNode node2 = deque.poll();
            if (node1 == null && node2 == null) continue;
            int val = (node1 == null ? 0 : node1.val) + (node2 == null ? 0 : node2.val);
            if (node1 == null) {
                node1 = new TreeNode(val);
            } else {
                node1.val = val;
            }
            if (node1.left == null && node2 != null && node2.left != null) {
                node1.left = new TreeNode(0);
            }
            if (node1.right == null && node2 != null && node2.right != null) {
                node1.right = new TreeNode(0);
            }

            if (node1.left != null) {
                deque.offer(node1.left);
                deque.offer(node2 == null ? null : node2.left);
            }
            if (node1.right != null) {
                deque.offer(node1.right);
                deque.offer(node2 == null ? null : node2.right);
            }
        }

            return root1;
    }
    public static void main(String[] args) {
        // 测试代码
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(2);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(9);
        TreeNode treeNode1 = new TreeNode(2);
        treeNode1.left = new TreeNode(1);
        treeNode1.right = new TreeNode(3);
        treeNode1.left.left = new TreeNode(5);
        treeNode1.left.right = new TreeNode(4);
        treeNode1.right.right = new TreeNode(5);
        TreeNode newTreeNode = solution.mergeTrees(treeNode, treeNode1);
        System.out.println(newTreeNode.val + " " + newTreeNode.left.val + " " + newTreeNode.right.val + " " + newTreeNode.left.right.val + " " + newTreeNode.right.right.val);
    }
}