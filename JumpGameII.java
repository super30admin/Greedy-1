// Time Complexity : O(n), n - > length of input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: 
// We can visualize this problem like a BFS problem wherein we need to consider each interval as one level.
// Here interval is determined by the value at the start index of the scope.
// In each interval we try to find the farthest index that we can reach to. Whenever we reach the last index, we can return the jump value from there itself by incrementing it by 1.

class Solution {
    public int jump(int[] nums) {
        // edge case
        if(nums == null || nums.length < 2) {
            return 0;
        }
        
        // get scope of the interval
        int scope = 0;
        // save the max index till where we can go
        int maxIndex = 0;
        // number of jumps
        int jumps = 0;
        
        for(int i = 0; i < nums.length; i++) {
            // finding the farthest index that current interval can provide
            if(maxIndex < nums[i]+i)
                maxIndex = nums[i]+i;
            // scenario when last index can be obtained
            if(maxIndex == nums.length-1)
                return jumps+1;
            // updating the scope to start next interval/level
            if(scope == i) {
                scope = maxIndex;
                jumps++;
            }
        }
        return jumps;
    }
}

