package 二叉搜索树中的搜索;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null)
            deque.offerLast(root);
        if (root == null || root.val == val) {
            return root;
        }
        while (!deque.isEmpty()) {

            for (int i = 0; i < deque.size(); i++) {
                TreeNode node = deque.poll();
                if (node.val == val) {
                    return node;
                }
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) deque
                        .offer(node.right);
            }
        }
        // 遍历完整个树都没有找到目标值
        return null;
    }


    public TreeNode searchBST1(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        //二叉搜索树的左子树小于根小于右子树
        if (root.val > val) {
            return searchBST1(root.left, val);
        } else {
            return searchBST1(root.right, val);
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode
                (7, new TreeNode(6), new TreeNode(9)));
        System.out.println(solution.searchBST(root, 2));
    }
}