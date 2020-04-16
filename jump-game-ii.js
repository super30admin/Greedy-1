// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number[]} nums
 * @return {number}
 */
const jump = (nums) => {
    if (!nums || !nums.length || nums.length == 1) return 0;
    
    let scope = 0;
    let farthest = 0;
    let jumps = 0;
    
    for (let i = 0; i < nums.length; i++) {
        farthest = Math.max(farthest, i + nums[i]);
        if (farthest >= nums.length - 1) return jumps + 1;
        if (i == scope) {
            jumps++;
            scope = farthest;
        }
    }
};
