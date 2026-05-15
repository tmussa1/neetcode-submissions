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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, LinkedList<Integer>>> nodeMap = new TreeMap<>();

        sortVertically(root, 0, 0, nodeMap);

        for(TreeMap<Integer, LinkedList<Integer>> entry: nodeMap.values()){
            List<Integer> currList = new ArrayList<>();
            for(LinkedList<Integer> lst: entry.values()){
                currList.addAll(lst);
            }
            result.add(currList);
        }

        System.out.println(nodeMap);

        return result;
    }

    private void sortVertically(TreeNode root, int sum, int level, TreeMap<Integer, TreeMap<Integer, LinkedList<Integer>>> nodeMap){

        if(root == null){
            return;
        }

        TreeMap<Integer, LinkedList<Integer>> valueMap = nodeMap.getOrDefault(sum, new TreeMap<>());
        LinkedList<Integer> values = valueMap.getOrDefault(level, new LinkedList<>());
        values.add(root.val);
        valueMap.put(level, values);
        nodeMap.put(sum, valueMap);

        sortVertically(root.left, sum - 1, level + 1, nodeMap);
        sortVertically(root.right, sum + 1, level + 1, nodeMap);
    }
}