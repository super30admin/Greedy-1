// Time Complexity : O(2n)
// Space Complexity : O(n)
// n is the length of given array ratings
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        // left pass
        for(int i = 1; i< n ;  i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1]+1;
            }
        }
        int sum = candies[n-1];
        // right pass
        for(int i = n-2 ; i >= 0 ; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i+1]+1, candies[i]);
            }
            sum += candies[i];
        }
        return sum;
    }
}
