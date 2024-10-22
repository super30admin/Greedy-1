// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.


package Greedy-1;

public class Problem3 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int candies = 1;
        int up = 0, down = 0, peak = 0;

        for(int i = 1; i < n; i++){
            //increasing
            if(ratings[i] > ratings[i-1]){
                up++;
                peak = up;
                down = 0;
                candies += 1 + up;
            }else if(ratings[i]< ratings[i-1]){ // decreasing
                up = 0;
                down++;
                candies += 1 + down;
                // peak is counted twice so decrease it.
                if(peak >= down){
                    candies -= 1;
                }
            }else{ //equal
                up = down = peak = 0;
                candies +=1;
            }
        }
        return candies;
    }

}
