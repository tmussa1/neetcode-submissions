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

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxEachNode(root);
        return max;
    }

    private int maxEachNode(TreeNode root){

        if(root == null){
            return 0;
        }

        int left = Math.max(maxEachNode(root.left), 0);
        int right = Math.max(maxEachNode(root.right), 0);

        int localMax = left + right + root.val;

        max = Math.max(localMax, max);

        return root.val + Math.max(left, right);
    }
}
