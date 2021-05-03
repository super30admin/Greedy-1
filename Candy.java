// Time Complexity :O(3n) asymptotically it will be O(n)
// Space Complexity :O(n) to store all the candies in an extra array
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int candy(int[] ratings) {
        
      if(ratings == null || ratings.length==0)
      {
        return 0;
      }
      
      int n = ratings.length;
      int[] candies = new int[n];
      Arrays.fill(candies,1);
      
      //going from left to right
      for(int i=1;i<n;i++)
      {
        if(ratings[i]>ratings[i-1])
        {
          candies[i] = candies[i-1]+1;
        }
      }
      
      //going form right to left
      for(int i=n-2;i>=0;i--)
      {
        if(ratings[i]>ratings[i+1])
        {
          candies[i] = Math.max(candies[i+1]+1,candies[i]);
        }
      }
      int result = 0;
      for(int c : candies)
      {
        result += c;
      }
      return result;
    }
}