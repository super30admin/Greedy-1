// Problem2 Jump Game II (https://leetcode.com/problems/jump-game-ii/)

// DFS - time limit exceeds
// Time Complexity : O(2^n)
// Space Complexity : O(n)

// DP
// TC: O(n)
// SC: O(1)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

let minsteps;
let dfs = (nums, idx, steps) => {
    if (idx >= nums.length - 1) {
        minsteps = Math.min(minsteps, steps)
        return;
    }
    if (steps > minsteps) {
        return;
    }
    for (let i = 1; i <= nums[idx]; i++) {
        let newIdx = idx + i;
        dfs(nums, newIdx, steps + 1);
    }

}
/**
 * @param {number[]} nums
 * @return {number}
 */
var jump = function (nums) {
    if (nums.length < 2)
        return 0;

    // DFS 
    // Time limit exceeds
    // minsteps = Infinity;
    // dfs(nums,0,0);
    // return minsteps;

    let jumps = 1;
    let currInterval = nums[0];
    let nextInterval = nums[0];
    for (let i = 0; i < nums.length; i++) {
        nextInterval = Math.max(nextInterval, i + nums[i]);
        if (i !== nums.length - 1 && i == currInterval) {
            jumps++;
            currInterval = nextInterval;
        }
    }
    return jumps;
};
