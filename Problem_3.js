// Problem3 Candy (https://leetcode.com/problems/candy/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * @param {number[]} ratings
 * @return {number}
 */
var candy = function (ratings) {
    if (ratings === null || ratings.length === 0)
        return 0;
    let n = ratings.length;
    let result = new Array(n);
    result.fill(1);
    // Moving from left to right and checking left neighbors
    for (let i = 1; i < n; i++) {
        if (ratings[i] > ratings[i - 1]) {
            result[i] = result[i - 1] + 1;
        }
    }
    // Moving from right to left and checking right neighbors
    let total = result[n - 1];
    for (let i = n - 2; i >= 0; i--) {
        if (ratings[i] > ratings[i + 1]) {
            result[i] = Math.max(result[i], result[i + 1] + 1);
        }
        total += result[i];
    }
    return total;
};