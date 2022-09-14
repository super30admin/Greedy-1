// Time Complexity : O(2n) = O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinimumCandies {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if(ratings == null || n == 0) return 0;
        int[] candies = new int[n];
        //Initial fill the candies array with 1 (Each will have 1)
        Arrays.fill(candies, 1);

        //Scan the ratings from left to right and if current ratings is greater than left ratings, update the corresponding candies value with left candies value + 1.
        for(int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1]+1;
            }
        }

        //Scan the ratings from right to left and if current ratings is greater than right ratings, update the corresponding candies value with the max of currect candies value and (right candies value + 1).
        int totalCandies = candies[n-1];
        for(int i=n-2; i>=0; i--) {
            if(ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }
            //calculate total candies
            totalCandies += candies[i];
        }
        return totalCandies;
    }
}