package 二叉树的右视图;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return res;
        }
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.pollFirst();
                assert poll != null;

                if (poll.right != null) {
                    deque.offer(poll.right);
                }
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                //1让树的每层的第一个节点进行入数组
                if (i == 0) {
                    res.add(poll.val);
                }
                //2 当树的左节点先入队时
                //当i等于size-1时，说明当前层已经处理完毕，将下一层第一个节点加入
//                if(i == size - 1){
//                    res.add(poll.val);
//                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // 测试代码
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(new Solution().rightSideView(root));
        // 输出：[1, 2, 5]
    }
}