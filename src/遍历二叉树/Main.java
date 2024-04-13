package 遍历二叉树;

import javax.swing.tree.TreeNode;

public class Main {
    public void  inorderTraversal(TreeNode root) {
        if(root!=null){
            inorderTraversal(root.left);
            System.out.print(root.var+" ");
            inorderTraversal(root.right);
        }
    }
    public void  preorderTraversal(TreeNode root) {
        if (root!=null){
            System.out.print(root.var+" ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }
    public void  postorderTraversal(TreeNode root) {
        if(root!=null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.var+" ");
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        new Main().inorderTraversal(treeNode);
        System.out.println();
        new  Main().preorderTraversal(treeNode);
        System.out.println();
        new  Main().postorderTraversal(treeNode);


    }
   static class  TreeNode {
        int var;
        TreeNode left;
        TreeNode right;

        public TreeNode(int var) {
            this.var = var;
        }
    }
}
