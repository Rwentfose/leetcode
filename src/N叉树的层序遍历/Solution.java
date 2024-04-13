package N叉树的层序遍历;


import common.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = deque.poll();
                if(node!= null){
                    list.add(node.val);
                    if (node.children != null) {
                        for (Node child : node.children) {
                            if (child != null) {
                                deque.offer(child);
                            }
                        }
                    }
                }

                // 这里使用 addAll 而不是一个一个添加，可以提高效率
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();


    }
}