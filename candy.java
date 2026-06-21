// Time Complexity : O(n) because we traverse the ratings array once
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We track increasing and decreasing slopes instead of storing candies for every child.
// For every mountain (upward slope followed by downward slope), we calculate candies using arithmetic progression sums.
// The peak gets counted in both directions, so we add the larger slope once to avoid double counting.

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int up = 0, down = 0;
        int oldSlope = 0, newSlope = 0;
        int candies = 0;

        for(int i = 1; i < n; i++) {

            // determine current slope
            if(ratings[i] > ratings[i - 1]) {
                newSlope = 1;
            } else if(ratings[i] < ratings[i - 1]) {
                newSlope = -1;
            } else {
                newSlope = 0;
            }

            // end of a mountain or valley
            if((oldSlope < 0 && newSlope >= 0) || (oldSlope > 0 && newSlope == 0)) {
                candies += count(up) + count(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }

            if(newSlope == 1) {
                up++;
            } else if(newSlope == -1) {
                down++;
            } else {
                candies++;
            }

            oldSlope = newSlope;
        }

        // process last slope
        candies += count(up) + count(down) + Math.max(up, down);

        // add first child
        return candies + 1;
    }

    private int count(int n) {
        return n * (n + 1) / 2;
    }
}