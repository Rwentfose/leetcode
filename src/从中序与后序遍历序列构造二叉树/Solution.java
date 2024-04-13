package 从中序与后序遍历序列构造二叉树;

import common.TreeNode;

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {

            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }

        }

        return  new TreeNode(rootVal, build(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + rootIndex- inStart - 1), build(inorder, rootIndex + 1, inEnd, postorder, postStart + rootIndex - inStart, postEnd - 1));
    }
}