package Dec23;

import java.util.Arrays;

class Candy {
    public int candy(int[] ratings) {
        
        /*
        Time complexity: O(n) + O(n) ~= O(n)
        Space complexity: O(n) because we are using an extra array space (for storing candies count to be given to each child) of size n.
        
        Approach: 
        Travel from left to right in 1st iteration on given ratings array.
        Travel from right to left in 2nd iteration on given ratings array.
        Increment count of candies for current child in both of the above iterations depending on whether current child's rating is greater than its left and right child. 
        
        */
        
        // edge
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        
        // left pass : O(n)
        for (int i = 1; i < ratings.length; i++) {
          if (ratings[i-1] < ratings[i]) {
              candies[i] = candies[i-1] + 1;
          }  
        }
        
        // right pass : O(n)
        for (int i =ratings.length-2; i >= 0; i--) {
          if (ratings[i+1] < ratings[i]) {
              candies[i] = Math.max(candies[i], candies[i+1] + 1);
          }  
        }
        
        int sum = 0;
        for (int candyRes : candies) {
            sum += candyRes;
        }
        
        return sum;
        
    }
}