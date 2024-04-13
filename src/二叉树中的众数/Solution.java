package 二叉树中的众数;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public int[] findMode(TreeNode root) {
        TreeNode per = null;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
         TreeNode node = root;
         int count = 0;
         int countMax = 0;
         if (node == null){
             return res.stream().mapToInt(Integer::valueOf).toArray();
         }
        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            // 处理当前节点
            if (per == null || per.val != node.val){
               count = 1;
            }else if (per.val == node.val){
                count++;
            }
            if (count > countMax){
                countMax = count;
                res.clear();
                res.add(node.val);
            }else if(count == countMax){
                res.add(node.val);
            }
            per = node;
            // ...
            node = node.right;
        }
        return  res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        int[] res = solution.findMode(root);
        for (int re : res) {
            System.out.print(re + " ");
        }
        System.out.println();

    }
}