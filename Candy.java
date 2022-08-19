// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int candy(int[] ratings) {

        if (ratings == null || ratings.length == 0)
            return 0;

        int n = ratings.length;

        int[] candies = new int[n];

        //each kid will have at least one candy
        Arrays.fill(candies, 1);

        //left pass - if rating is greater than left neighbor, increase candies by 1
        for(int i=1; i<n; i++) {
            if(ratings[i] > ratings[i-1])
                candies[i] = candies[i-1] + 1;
        }

        //right pass - if rating is greater than right neighbor and current number of candies is greater than 1 + candies of right neighbor, increase by 1

        //calculate sum in this pass itself
        int sum = candies[n-1];

        for(int i=n-2; i>=0; i--) {
            if(ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], 1 + candies[i+1]);
            }
            sum += candies[i];
        }
        return sum;
    }
}
