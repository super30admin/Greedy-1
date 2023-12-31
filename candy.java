// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int candy(int[] ratings) {
        int r = ratings.length;
        if(r == 0)
            return 0;
        if(r == 1)
            return 1;
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for(int i = 1; i < r; i++) {
            if(ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
       int sum = candies[r - 1];
        for(int i = r - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
            }
            sum += candies[i];
        }
        return sum;
    }
}