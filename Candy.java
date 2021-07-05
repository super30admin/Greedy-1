// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) since we are iterating through the entire array linearily thrice
//Space Complexity: O(1) since we are not using any extra space

class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        
        //left pass
        for(int i = 1;  i < ratings.length; i++){
            if(ratings[i] > ratings[i - 1]){
                candies[i] = candies[i-1] + 1;
            }
        }
        
        //right pass
        for(int i = ratings.length - 2; i >=0 ; i--){
            if(ratings[i] > ratings[i+1]){
                    candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }            
        }
        
        int sum = 0;
        for(int i = 0; i < candies.length; i++){
            sum += candies[i];
        }
        
        return sum;        
    }
}