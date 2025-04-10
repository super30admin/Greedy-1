// TC: O(n)
// SC: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // TC = O(n), SC = O(1)
    // 2 passes, compare left & right neighbors in each pass
    public int candy(int[] ratings) {
        int n = ratings.length;
        if(ratings == null || n == 0) return 0;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        // 1st pass to compare with left neighbors
        for(int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;
        }
        // 2nd pass to compare with right neighbors
        int sum = candies[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                // check for the condition, if already greater dont replace
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            sum += candies[i];
        }
        return sum;
    }
}