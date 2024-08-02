class JumpGameII {
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return 0;
        }

        int jumps = 1;
        int currInterval = nums[0];
        int nextInterval = nums[0];

        for(int i=1; i<nums.length; i++) {
            nextInterval = Math.max(nextInterval, nums[i]+i);
            //because i == currInterval will be true at the last index as well, but we are not supposed to take any further jumps from there
            if(i == nums.length-1) continue;
            if(i == currInterval) {
                jumps++;
                currInterval = nextInterval;
            }
        }

        return jumps;
    }
}
