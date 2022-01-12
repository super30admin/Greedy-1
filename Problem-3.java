// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        
        for(int i=0;i<candies.length;i++) {
            
            candies[i]++;
        }
        
        for(int i = 1;i < ratings.length;i++) {
            
            if(ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1]+1;
            }  
        }
        
        int count = candies[ratings.length-1];
        for(int i = ratings.length-2;i >= 0;i--) {
            
            if(ratings[i] > ratings[i+1] && candies[i] <= candies[i+1]) {
                candies[i] = candies[i+1] + 1;
            }
            
            count += candies[i];
        }
        
        return count;
    }
}