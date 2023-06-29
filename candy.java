// TC - O(n)
// SC - O(n) for the candies array used to calculate the sum

/*
 * Approach
 * We use a Greedy approach here and do 2 passes in order to fill a resultant
 * array of the number of candies given to each child. We initially give 1
 * candy to each child. Then we do 2 passes over the ratings list (L->R and
 * R->L). In the first pass, we check the ratings aginst LEFT neighbor and
 * assign candies accordingly, and in the second pass, we do the same for the
 * RIGHT neighbor.
 */

import java.util.*;

class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) {
            return 0;
        }

        int n = ratings.length;
        int total = 0;
        int[] candies = new int[n];
        Arrays.fill(candies, 1); // give 1 candy to each child

        // first pass - check against left neighbor
        for(int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }

        total = candies[n-1]; // initialize total to last element

        // second pass - check against right neighbor
        for(int i = n-2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
            total += candies[i];
        }

        return total;
    }
}