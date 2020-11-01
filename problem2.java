//Time:O(N)
//Space :O(1)
class Solution {
    public int jump(int[] nums) {
        if (nums.length == 0 || nums == null || nums.length == 1)
            return 0;

        int currInterval = nums[0];
        int nextInterval = nums[0];
        int jumps = 1;
        for (int i = 0; i < nums.length; i++) {

            nextInterval = Math.max(nextInterval, nums[i] + i);

            if (i == currInterval) {
                jumps++;
                currInterval = nextInterval;
            }

            if (currInterval >= nums.length - 1)
                break;

        }

        return jumps;
    }
}