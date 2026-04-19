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

class Solution {
    public int maxDepth(TreeNode root) {
        return findDepth(root);
    }

    private int findDepth(TreeNode root){

        if(root == null){
            return 0;
        }

        int left = findDepth(root.left);
        int right = findDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
