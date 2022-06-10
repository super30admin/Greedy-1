// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int candy(int[] ratings) {
        
        int[] candies = new int[ratings.length];
        
        int result = 0;
        candies[0] = 1;
        // Step 1: left to right
        for(int i = 1; i < ratings.length; i++) {
            candies[i] = 1;
            if(ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }
        
        // Step 2: right to left
        result = candies[ratings.length - 1];
        for(int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }            
            result += candies[i];
        }
        
        return result;
    }
}