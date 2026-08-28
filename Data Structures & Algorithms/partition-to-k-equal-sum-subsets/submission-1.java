class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = Arrays.stream(nums).sum();

        if (sum % k != 0) {
            return false;
        }

        int target = sum / k;

        Arrays.sort(nums);

        if (nums[nums.length - 1] > target) {
            return false;
        }

        boolean[] used = new boolean[nums.length];

        return canPartition(nums, used, k, 0, target, 0);
    }

    private boolean canPartition(
        int[] nums,
        boolean[] used,
        int k,
        int currSum,
        int target,
        int index
    ) {
        
        if (k == 1) {
            return true;
        }

        if (currSum == target) {
            return canPartition(
                nums,
                used,
                k - 1,
                0,
                target,
                0
            );
        }

        for (int i = index; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }

            if (currSum + nums[i] > target) {
                break;
            }

            used[i] = true;

            if (canPartition(
                    nums,
                    used,
                    k,
                    currSum + nums[i],
                    target,
                    i + 1)) {
                return true;
            }

            used[i] = false;
        }

        return false;
    }
}