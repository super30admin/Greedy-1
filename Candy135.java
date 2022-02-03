/* Time Complexity : O(n)
 Space Complexity : O(n)
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No
 **/

// Your code here along with comments explaining your approach
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int candies[] = new int[n];
        Arrays.fill(candies, 1);
        // left pass;
        for( int i = 1 ; i<n ; i++){
            if(ratings[i]>ratings[i-1]){
                candies[i] = candies[i-1]+1;
            }
        }
        int sum = candies[n-1];
        for(int m =  ratings.length-2 ; m>=0 ;m--){
            if(ratings[m]>ratings[m+1]){
                 candies[m] = Math.max(candies[m],candies[m+1]+1);
            }
            sum = sum + candies[m];
        }
        
        // int count = 0;
        // for(int i =0; i<n; i++){
        //     count = count +  candies[i] ;
        // }
        return sum;
        
    }
}
