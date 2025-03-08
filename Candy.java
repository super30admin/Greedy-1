// In this problem, declaring an array candies of ratings length, filling all values with 1. Now, first looping from 1 to n-1, for
// each value, checking it's left neighbour, if it's value is greater than it's left neighbour, increasing candy count in candies 
// array by the candy count of left neighbour + 1. Then in second loop, running a loop from n-2 to 0, checking right neighbour of
// each value. If value is greater than it's right neighbour, than increasing it's candy count by max of rightNeighbour+1, current
// candy count.
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int candy(int[] ratings) {
        // Base case
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int n = ratings.length;
        int[] candies = new int[n];
        // Fill with 1
        Arrays.fill(candies, 1);
        // First loop
        for (int i = 1; i < n; i++) {
            // Check left neighbour is having less rating
            if (ratings[i] > ratings[i - 1]) {
                // Then increase candy count
                candies[i] = candies[i - 1] + 1;
            }
        }
        // Keep sum of candies variable and give last index value
        int sum = candies[n - 1];
        // Loop from second last index
        for (int i = n - 2; i >= 0; i--) {
            // Check if right neighbour rating is less, increase the candy count if required
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            // Also, add to the sum the current candy count
            sum = candies[i] + sum;
        }
        // Return sum
        return sum;
    }
}