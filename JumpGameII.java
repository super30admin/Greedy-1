
class JumpGameII {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;

        int currInterval = nums[0], nextInterval = nums[0];
        int jumps = 1;
        for(int i = 0; i < nums.length ; i++)
        {
            if(currInterval == nums.length) return jumps;
            nextInterval = Math.max(nextInterval, nums[i] + i);
            if(i == currInterval && currInterval != nums.length - 1)
            {
                currInterval = nextInterval;
                jumps++;
            }
        }

        return jumps;
    }
}