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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        removeAll(result, root);
        return result;
    }

    private void removeAll(List<List<Integer>> result, TreeNode root){

        TreeNode curr = root;

        while(curr != null){
            List<Integer> currList = new ArrayList<>();

            if(root.left == null
                    && root.right == null){

                currList.add(root.val);

                result.add(currList);

                curr = null;

                continue;
            }

            removeLeaves(currList, curr, null);
            result.add(currList);
            curr = root;
        }
    }

    private void removeLeaves(List<Integer> currList, TreeNode root, TreeNode parent){

        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            currList.add(root.val);
            if(parent != null && parent.left == root){
                parent.left = null;
            }
            if(parent != null && parent.right == root){
                parent.right = null;
            }
            return;
        }

        removeLeaves(currList, root.left, root);
        removeLeaves(currList, root.right, root);
    }
}
