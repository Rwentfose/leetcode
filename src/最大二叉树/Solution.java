package 最大二叉树;

import common.TreeNode;

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int leftIndex, int rightIndex) {
        if(rightIndex-leftIndex == 0){
            return  new TreeNode(nums[leftIndex]);
        }
        if (rightIndex - leftIndex < 1) {// 没有元素了
            return null;
        }
        int maxIndex = leftIndex;
        int max = nums[maxIndex];
            for (int i = leftIndex + 1; i <= rightIndex; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    maxIndex = i;
                }
            }
        TreeNode treeNode = new TreeNode(max);
        treeNode.left = construct(nums, leftIndex, maxIndex-1);
        treeNode.right = construct(nums, maxIndex+1, rightIndex);
        return treeNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,2,1,6,0,5};
        TreeNode treeNode = solution.constructMaximumBinaryTree(nums);
        System.out.println(treeNode.val+"左："+treeNode.left.val+"右："+treeNode.right.val);
    }
}