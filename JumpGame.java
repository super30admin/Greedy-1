// Time Complexity : O(n), n - > length of input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: 
// The intuitive approach to solve this problem is to visualize it backwards. We need to reach the final index from 0. 
// So, considering goal state to index n, we can trace back to see if we have a path from the index before the final one and so on to reach n. If we have a path, we will further check if we can reach this point by considering other elements before this.

class Solution {
    public boolean canJump(int[] nums) {
        // edge case
        if(nums == null || nums.length <= 1)
            return true;
        int n = nums.length;
        int goalIndex = n-1;
        for(int i = goalIndex-1; i >= 0; i--) {
           if(nums[i]+i >= goalIndex)
               goalIndex = i;
        }
        return goalIndex == 0;
    }
}
