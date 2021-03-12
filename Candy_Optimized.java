//Problem 138: Candy
//TC:O(n)
//SC:O(n), for creating candies array

/*
 Steps: Optimized: Use the concept of left pass and right pass
Left Pass: Start from the 1st index, if ratings at current index is greater than the ratings at the previous index, then just increment the candies count by 1;
Right Pass : Start from the last index-1, if ratings at current index is greater than the ratings at current index+1, then find max between the candies at current index and the candies at (current index+1)+1, whichever is bigger just set current index candies value to that.
Finally add the values of all the candies and return the sum.
*/

//Optimized
import java.util.*;

class Solution138 {
    public int candy(int[] ratings) {
        
        if(ratings==null || ratings.length==0) return 0;
        
        //TC:O(N) || SC:O(N)
        
        int[] candies = new int[ratings.length];
        Arrays.fill(candies,1);
        
        //left pass
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
               candies[i] = candies[i-1]+1;    
            }
        }
        
        //right pass
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
               candies[i] = Math.max(candies[i],candies[i+1]+1);    
            }
        }
        
        //calculate total candies
        int sum=0;
        for(int elem:candies){
            sum += elem;
        }
        return sum;
    }
}