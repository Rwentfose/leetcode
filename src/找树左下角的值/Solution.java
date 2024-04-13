package 找树左下角的值;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int res = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        if (root== null){
            return 0;
        }
        deque.offer(root);
        while (!deque.isEmpty()){
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (i == 0){
                    res = node.val;
                }
                if (node.left != null)
                    deque.offer(node.left);
                if (node.right != null)
                    deque.offer(node.right);
            }
        }
        return res;
    }
}