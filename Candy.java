// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// Initialization: Start by giving each child one candy and traverse from left to right, increasing candies for children with higher ratings than the previous child.
//Right to Left Adjustment: Traverse from right to left, adjusting candies to ensure children with higher ratings than the next child get more candies.
//Calculate Total: Sum up the candies to find the minimum total needed to satisfy the conditions.

class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        // check ratings with left element
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        int min = candies[n-1];
        // check ratings with right element
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
            }
            min = min + candies[i];
        }
        return min;
    }
}