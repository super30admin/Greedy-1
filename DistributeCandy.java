// Time Complexity : O(N)
// Space Complexity : O(1), ignoring the output array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class DistributeCandy {
    class Solution {
        public int candy(int[] ratings) {
            int n = ratings.length;
            int[] candies = new int[n];
            int sum = 0;
            Arrays.fill(candies, 1);

            //left pass:- check left neghbour if it is smaller

            for(int i = 1; i < n; i++) {
                if(ratings[i-1] < ratings[i]) {
                    candies[i] = candies[i-1] + 1;
                }
            }
            //right pass:- check right neghbot if it is smaller
            int numCandies = candies[n-1];
            for(int i = n-2; i >= 0; i--) {
                if(ratings[i] > ratings[i+1]) {
                    candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
                }
                numCandies += candies[i];
            }

            return numCandies;
        }
    }

}
