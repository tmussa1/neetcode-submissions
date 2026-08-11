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

public class Codec {

    int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root == null){
            return "N";
        }
        
        StringBuilder builder = new StringBuilder();

        String left = serialize(root.left);
        String right = serialize(root.right);

        builder.append(root.val + "," + left + "," + right);

        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String [] nodes = data.split(",");
        
        return deserialize(data, nodes);
    }

    private TreeNode deserialize(String data, String [] nodes) {
        if(index == nodes.length || nodes[index].equals("N")){
            index++;
            return null;
        }

        int node = Integer.parseInt(nodes[index++]);
        TreeNode root = new TreeNode(node);
        root.left = deserialize(data, nodes);
        root.right = deserialize(data, nodes);
        
        return root;
    }
}
