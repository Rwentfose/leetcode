package 二叉搜索树的最小差值;

import common.TreeNode;

import java.util.*;

class Solution {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> objects = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        int m = 999999;
        if (root != null) {
            deque.offer(root);
            while (!deque.isEmpty()) {
                for (int i = 0; i < deque.size(); i++) {
                    TreeNode node = deque.poll();
                    objects.add(node.val);
                    if (node.left != null) {
                        deque.offer(node.left);
                    }
                    if (node.right != null) {
                        deque.offer(node.right);
                    }
                }
            }
            Collections.sort(objects);
            for (int i = 0; i < objects.size()-1 ; i++) {
            m = (Math.min(Math.abs(objects.get(i) - objects.get(i + 1)),m));
                System.out.println(objects.get(i));
            }
        }
        return m;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] nums = {1,3,2,5,4};
        //int[] nums = {2,2,2,2,2};
        TreeNode treeNode = new TreeNode(4, new TreeNode(2, new TreeNode(6), new TreeNode(1)), new TreeNode(3));
        System.out.println(solution.getMinimumDifference(treeNode));
    }
}