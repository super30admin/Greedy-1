// Time Complexity : O(n)
// Space Complexity : O(n) as we are using an additional array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Initialize candies[]. Start by assigning 1 candy to all the element. Then start processing left neighbour and if rating is higher than the left neighbour then increment. Then process right neighbour and again increment if rating is greater than the right neighbour.
 */
class Solution {
    public int candy(int[] ratings) {

        if(ratings == null || ratings.length == 0){
            return 0;
        }

        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        //Compare with left neighbour
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            }
        }

        int total = candies[n-1];

        //Compare with right neighbour
        for(int i = n -2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }

            total += candies[i];
        }

        return total;
    }
}