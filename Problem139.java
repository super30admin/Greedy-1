//TC: O(n)
//SC: O(1)
class Solution {
    public int jump(int[] nums) {
        int jumps = 0;         // Number of jumps we have made so far
        int currentEnd = 0;     // Farthest point reachable with the current number of jumps
        int farthest = 0;       // Farthest point reachable overall
        
        // Traverse through the array, but no need to process the last index
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest point we can reach
            farthest = Math.max(farthest, i + nums[i]);
            
            // If we reach the end of the range for the current jump
            if (i == currentEnd) {
                jumps++;              // Increment the jump count
                currentEnd = farthest; // Update the range we can reach in the next jump
            }
        }
        
        return jumps; // Return the number of jumps
    }
}
