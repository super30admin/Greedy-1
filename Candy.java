// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for(int i = 1; i<n;i++){
            if(ratings[i-1] < ratings[i]){
                candies[i] = candies[i-1] + 1;
            }
        }
        int total = candies[n-1];
        for(int i=n-2; i>=0; i--){
            if(ratings[i+1] < ratings[i]){
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
            total += candies[i];
        }
        return total;
    }
}