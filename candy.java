// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    
    public int candy(int[] ratings) {
        
        int n = ratings.length;
        int candies[] = new int[n];
        
        Arrays.fill(candies, 1);
        int output=0;
        
        for(int i=1;i<n;i++) {
            if(ratings[i]>ratings[i-1]) {
                candies[i] = candies[i-1]+1;
            }
        }
        
        output=candies[n-1];
        for(int i=n-2;i>=0;i--) {
            if(ratings[i]>ratings[i+1]) {
                candies[i] = Math.max(candies[i],candies[i+1]+1);
            }
            output+=candies[i];
        }
        
        return output;
        
    }
    
}
