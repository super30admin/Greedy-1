// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        if(ratings.length == 0 || ratings == null)
            return 0;
        
        int n = ratings.length;
        int[] candies = new int[n];
        //everyone starts with 1 candy
        Arrays.fill(candies, 1);
        
        //left pass: check if the left neighbor is higher or not
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i - 1]){
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        int minCandies = candies[n - 1];
        //right pass: traverse from back to check if right neighbor is higher or not
        for(int i = n - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            minCandies += candies[i];
        }
        
        return minCandies;
    }
}