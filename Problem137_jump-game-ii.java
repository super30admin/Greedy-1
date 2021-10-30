// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int jump(int[] nums) {
        // edge case
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length < 2)
            return 0;
        
        // logic
        int nextInt = nums[0];
        int currInt = nums[0];
        int jumps = 1;
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