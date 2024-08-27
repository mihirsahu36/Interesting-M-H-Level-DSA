/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


//104. Maximum Depth of Binary Tree
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}


//111. Minimum Depth of Binary Tree
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        int leftDepth=minDepth(root.left);
        int rightDepth=minDepth(root.right);
        return Math.min(leftDepth, rightDepth) + 1;
    }
}


//110. Balanced Binary Tree
class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }
    private int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=height(root.left);
        int right=height(root.right);
        if(left==-1 || right==-1 || Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
