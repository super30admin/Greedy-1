class Solution {
    // TC:O(n) SC:O(1)
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        int jumps = 1;
        int currIdx = nums[0];
        int nextIdx = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            nextIdx = Math.max(nextIdx, i + nums[i]);
            if (i == currIdx) {
                currIdx = nextIdx;
                jumps++;
            }
        }
        return jumps;
    }
}