class Solution {
    public int jump(int[] nums) {
        
        int l = nums.length;
        if(l <= 1) return 0;
        
        int jumps = 0, maxReach = nums[0], steps = maxReach;
        
        for(int i = 1; i < l - 1; i++)
        {
            maxReach = Math.max(maxReach, i + nums[i]);
            steps--; 
            if(steps <= 0)
            {
                steps = maxReach - i;
                jumps++;
            }
        }
        return jumps + 1;
    }
}
//Time complexity : O(N)
//Space complexity : O(1)
