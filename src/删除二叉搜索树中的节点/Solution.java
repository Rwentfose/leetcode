package 删除二叉搜索树中的节点;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode node = root, prev = null;
        if (node == null){
          return null;
        }
        // 找到要删除的节点 prev 为其前一个节点
                if (node.val == key) {
                    if (prev != null) {
                        if (node.left==null && node.right==null){
                            if (prev.left == node) {
                                prev.left = null;
                            }else
                                prev.right = null;
                        }
                        if (node.left==null ||node.right==null){
                            if (prev.left == node) { // 如果要删除的节点是前一个节点的左子节点
                                prev.left = node.right != null ? node.right : node.left; // 将要删除节点的右子树或左子树连接到前一个节点的左侧
                            } else { // 如果要删除的节点是前一个节点的右子节点
                                prev.right = node.left != null ? node.left : node.right;// 将要删除节点的右子树或左子树连接到前一个节点的右侧
                            }
                        }
                        if (node.left!=null && node.right!=null){
                            if (prev.left == node){
                                prev.left = node.right;
                                while (prev.left!=null){
                                    prev = prev.left;
                                }
                                prev.left = node.left;
                            }else {
                                prev.right = node.left;
                                while (prev.right!=null){
                                    prev = prev.right;
                                }
                                prev.right = node.right;
                            }

                        }
                    } else { // 如果要删除的节点是根节点
                        if (node.left!=null&&node.right!=null){
                            TreeNode left =  node.left;
                            node = node.right;
                            while (node.left!=null){
                                node = node.left;
                            }
                            node.left = left;
                             return node;
                        }else {
                            return node.right != null ? node.right : node.left; // 返回新的根节点
                        }
                    }
                }
                prev = node;
                if (node.val > key) deleteNode(node.left, key);
                if (node.val < key) deleteNode(node.right, key);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode1 = new TreeNode(5);
        treeNode1.left = new TreeNode(3);
        treeNode1.left.left = new TreeNode(2);
        treeNode1.left.right = new TreeNode(4);
        treeNode1.right = new TreeNode(6);
        treeNode1.right.right = new TreeNode(7);
        TreeNode treeNode = solution.deleteNode(treeNode1, 7);

    }
}