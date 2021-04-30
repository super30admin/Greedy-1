class JumpGame {
    
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    
    public boolean canJump(int[] nums) {
        // Edge Case Checking
        if(nums == null || nums.length == 0)
            return false;
        
        // We start from the last position and check if we can reach that position from any position before it.
        // We keep doing this until we can reach 0th position / go out of bounds
        int destination = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--){
            if(i + nums[i] >= destination)
                destination = i;
        }

        // If we reach the 0th position - true otherwise false
        return destination == 0;
    }
}