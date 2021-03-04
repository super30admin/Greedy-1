// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Since everyone will get a candy, initialize result array with 1. Make a forward pass, while comparing if current element is greater than the previous element, and a backward pass to compare if current element is greater than the next element. If conditions satisfy make changes in the result array.

public class Candy {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        
        int[] candies = new int[ratings.length];
        
        Arrays.fill(candies, 1);
        
        int totalCandies = 0;
        
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            }
        }
        
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
            
            totalCandies = totalCandies + candies[i];
        }
        
        totalCandies = totalCandies + candies[ratings.length - 1];
        
        return totalCandies;
    }
}
