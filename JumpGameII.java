class JumpGameII {

    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public int jump(int[] nums) {
        // Edge Case Checking
        if(nums == null || nums.length <= 1)
            return 0;
        
        int jumps = 1;
        int currInterval = nums[0];
        int nextInterval = nums[0];
        
        for(int i = 0; i < nums.length; i++){
            // Maximize the reach
            if(i + nums[i] > nextInterval)
                nextInterval = i + nums[i];
            
            // Once we are done with all possible jumps for our current interval - move "i" to our next maximum reach and increment the jump count
            if(i == currInterval){
                currInterval = nextInterval;
                jumps++;
            }

            // If we go out of bounds - break
            if(currInterval >= nums.length - 1)
                break;
        }
        return jumps;
    }
}