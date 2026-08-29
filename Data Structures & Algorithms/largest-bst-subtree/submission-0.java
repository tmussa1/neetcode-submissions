class Solution {

    int max = 0;

    public int largestBSTSubtree(TreeNode root) {
        largest(root);
        return max;
    }

    private int[] largest(TreeNode root) {

        if (root == null) {
            return new int[] {
                Integer.MAX_VALUE,
                Integer.MIN_VALUE,
                0,
                1
            };
        }

        int[] left = largest(root.left);
        int[] right = largest(root.right);

        int[] result = new int[4];

        boolean isBST =
            left[3] == 1 &&
            right[3] == 1 &&
            root.val > left[1] &&
            root.val < right[0];

        if (isBST) {

            int min = Math.min(root.val, left[0]);
            int maxValue = Math.max(root.val, right[1]);

            int size = 1 + left[2] + right[2];

            result[0] = min;
            result[1] = maxValue;
            result[2] = size;
            result[3] = 1;

            max = Math.max(max, size);

        } else {
            result[0] = Integer.MIN_VALUE;
            result[1] = Integer.MAX_VALUE;
            result[2] = Math.max(left[2], right[2]);
            result[3] = 0;
        }

        return result;
    }
}