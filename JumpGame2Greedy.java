class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int farthest, jump, range;
        farthest = 0;
        jump = 0;
        range = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if(i == range) {
                jump++;
                range = farthest;
            }
        }
        return jump;
    }
}