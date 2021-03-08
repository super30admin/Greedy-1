// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

// Initialize currInt and nextInt to nums[0] and jumps to 1
// Iterate the array from left to right and update nextInt as Maximum of nextInt and i + nums[i]
// If index is equal to currInt, update currInt and increment jumps
// Return jumps after iteration is completed 

class Solution {
    public int jump(int[] nums) {

        if(nums == null || nums.length < 2) return 0;

        int jumps = 1;

        int currInt = nums[0], nextInt = nums[0];

        for(int i = 1; i < nums.length - 1; i++) {

            nextInt = Math.max(nextInt, i + nums[i]);

            if(i == currInt) {
                currInt = nextInt;
                jumps++;
            }
        }
        return jumps;
    }
} 
