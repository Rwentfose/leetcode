package 在每个树行中找最大值;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if(root== null){
            return list;
        }
        deque.offer(root);
        while (!deque.isEmpty()){
            int size = deque.size();

            int max = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                max = Math.max(max,node.val);
                if (node.left != null) deque.add(node.left);
                if (node.right != null)deque.add(node.right);
            }
            list.add(max);
        }
        return  list;
    }

    public static void main(String[] args) {
        List<Integer> list = new Solution().largestValues(new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(3, new TreeNode(9), new TreeNode(2))));
       list.forEach(System.out::println);
    }
}