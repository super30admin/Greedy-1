// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        int result = 0;

        //Make all the value of candy as 1
        for(int i=0; i<ratings.length; i++){
            candy[i] = 1;
        }
        
        //increment the value of candy if current rating is greater than previous rating
        for(int i=1; i<ratings.length; i++){
            if(ratings[i]>ratings[i-1]){
                candy[i] = candy[i-1] +1;
            }
        }
        
        //increment the value of candy if current rating is greater than previous rating
        result = candy[ratings.length-1];
        for(int i=ratings.length-2; i>=0; i--){
            if(ratings[i]>ratings[i+1]){
                candy[i] = Math.max(candy[i+1] +1, candy[i]);
                
            }
            result = result + candy[i];
        }
        
        return result;
    }
}