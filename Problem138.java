//TC: O(n)
//SC: O(1)
class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;  // Initially, the goal is the last index
        
        // Traverse the array backwards
        for (int i = nums.length - 2; i >= 0; i--) {
            // Check if you can jump from index i to the current goal
            if (i + nums[i] >= goal) {
                goal = i;  // Update the goal to the current index
            }
        }
        
        // Check if we've reached the start of the array
        return goal == 0;
    }
}
