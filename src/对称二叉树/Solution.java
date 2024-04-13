package 对称二叉树;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        //双端队列
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root.right);
        deque.addFirst(root.left);
        while (!deque.isEmpty()){
                TreeNode pollFirst = deque.pollFirst();
                TreeNode pollLast = deque.pollLast();
             if (pollFirst == null && pollLast == null) {
                continue;
             }
                if (pollFirst== null || pollLast == null||pollLast.val!=pollFirst.val){
                    return false;
                }
                deque.addFirst(pollFirst.left);
                deque.addFirst(pollFirst.right);
                deque.addLast(pollLast.right);
                deque.addLast(pollLast.left);
            }
        return  true;
    }
}