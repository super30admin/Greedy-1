// Problem1 Jump Game (https://leetcode.com/problems/jump-game/)

// Recursion
// TC: O(2^n)
// SC: O(n)

// 2 pointer // DP
// TC: O(n)
// SC: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

let visited;

var getResult = (nums, idx) => {
    // Base
    if (idx === nums.length - 1)
        return true;
    if (visited.has(idx))
        return false;

    // Logic
    visited.add(idx);
    for (let i = 1; i <= nums[idx]; i++) {
        let newIdx = idx + i;
        if (getResult(nums, newIdx)) {
            return true;
        }
    }
    return false;
}

/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function (nums) {
    if (nums.length < 2)
        return true;

    // Recursion
    // TC: O(2^n)
    // SC: O(n)
    // visited = new Set();
    // return getResult(nums, 0);

    // 2 pointer // DP
    // TC: O(n)
    // SC: O(1)
    let n = nums.length
    // Set destination as the last index
    let destination = n - 1;
    // Start from second last index
    for (let i = n - 2; i >= 0; i--) {
        // If we can reach the destination from here, make this new index as destination
        if (i + nums[i] >= destination) {
            destination = i;
        }
    }
    if (destination === 0)
        return true;
    return false;
};