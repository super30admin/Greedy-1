// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We will find the next max possible position from each spot
// If we find a spot having next max possible position greater than current
// we will swap. When we see that we have crossed or reached the end 
// we know its possible to reach and return true;
// When maxpossible and current max possible positions are equal to i
// This means we are stuck in a place from where its not possible to move forward
// At this time we can return false.
class Solution {
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        for(int i = 0; i < nums.length; i++){
            int jumps = nums[i];
            if(i + jumps > maxJump){
                maxJump = i + jumps;
            }
            if(maxJump >= nums.length - 1)
                return true;
            if(maxJump == i)
                return false;
            
        }
        return false;
    }
}