// Time Complexity : 0(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int n = ratings.length;
        int[] candies = new int[n];
        //Arrays.fill(candies, 1);
        int count = 0;

        // left to right
        candies[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }else{
                candies[i] = 1;
            }
        }
        // right to left
        count = candies[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
            }
            count += candies[i];
        }
        return count;
    }
}