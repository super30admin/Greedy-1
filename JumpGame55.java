class Solution {
    // Time Complexity:  O(n)
    // Space Complexity: O(1)
    
    // Approach: 
    //     Traversing from the right to left
    //     Moving destination to left when index+nums[index] >= destination
    public boolean canJump(int[] nums) {
         if(nums == null || nums.length == 0 || nums.length == 1)
             return true;
        
        int dest = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] + i >= dest)
                dest = i;
        }
        return dest == 0;
    }
}