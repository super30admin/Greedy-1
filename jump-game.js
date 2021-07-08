// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
    if (!nums || !nums.length) return true;
    if (nums.indexOf(0) == -1) return true;
    
    let destination = nums.length - 1;
    for (let i = destination - 1; i >= 0; i--) {
        if (i + nums[i] >= destination) {
            destination = i;
        }
    }
    
    return destination == 0;
};
