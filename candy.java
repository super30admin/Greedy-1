//Time Complexity : O(N)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Calculate candies that can put from left to right and then from right to
 * left. Then take the max of each index and add it to the sum. return sum.
 *
 */

class Solution {
    public int candy(int[] ratings) {
        if(ratings == null ) return 0;
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies,1);
        
        //left pass
        for(int i=1;i<n;i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            }
        }
        
        //right pass
        int sum = candies[n-1];
        for(int i=n-2;i>=0;i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }
            sum+= candies[i];
        }
        return sum;
    }
}
