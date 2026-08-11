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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        int level = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);


        while(!queue.isEmpty()){

            int size = queue.size();

            List<Integer> currList = new ArrayList<>();

            for(int i = 0; i < size; i++){

                TreeNode curr = queue.poll();

                currList.add(curr.val);

                if(curr.left != null){
                    queue.add(curr.left);       
                }
                
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }

            if(level % 2 == 1){
                Collections.reverse(currList);
            }

            result.add(currList);

            level++;
        }



        return result;
    }
}