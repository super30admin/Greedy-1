class Solution {
    public int jump(int[] nums) {
        if(nums.length <= 1) return 0;
        int currPos = nums[0];
        int nextPos = nums[0];
        int jumps = 1;
        
        for(int i=1;i<nums.length;i++) {
            
            // update greater nextpos
            if(i + nums[i] > nextPos)
                nextPos = i + nums[i];
            
            // update currpos to nextpos so far
            if(i == currPos && currPos != nums.length-1) {
                jumps++;
                currPos = nextPos;
            }
            
            // 
            if(currPos >= nums.length-1)
                return jumps;
        }
        
        return jumps;
    }
}