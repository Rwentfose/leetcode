package 二叉树的迭代遍历;

import 遍历二叉树.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
//中序遍历
class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
           if (cur != null){
               stack.push(cur);
               cur = cur.left;
           }else{
               cur = stack.pop();
               result.add(cur.val);
               cur = cur.right;
           }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(6);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(2);
        InorderTraversal inorderTraversal = new InorderTraversal();
        List<Integer> inorderTraversal1 = inorderTraversal.inorderTraversal(treeNode);

    }
}

// 后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
// 前序遍历顺序 中-左-右 入栈顺序：中-右-左 出栈顺序：中-左-右
     class PreorderTraversal{
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null){
                return result;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                result.add(node.val);
                if (node.right != null){
                    stack.push(node.right);
                }
                if (node.left != null){
                    stack.push(node.left);
                }
            }
            return result;
        }

    }


 class  TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int var) {
        this.val = var;
    }
}
