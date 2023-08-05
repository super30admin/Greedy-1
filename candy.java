// tc : O(n)
// sc : O(n)
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        candies[0] = 1;
        // iterate left to right and update the spots where fails;
        for(int i = 1 ; i<n ; i++){
            if(ratings[i]>ratings[i-1]) candies[i] = candies[i-1]+1;
            else candies[i] = 1;
        }
        int sum  = candies[n-1];
        // iterate right to left and update the spots where fails 
        // and simultaneously update the sum 
        for(int i = n-2; i>=0 ; i--){
            if(ratings[i]>ratings[i+1] && candies[i]<=candies[i+1]){
                candies[i] = candies[i+1] +1;
            }
            sum+=candies[i];
        }
        return sum;
    }
}
