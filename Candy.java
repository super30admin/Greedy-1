// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Initially store the candy values looking at only the left of current in an array
// Next store the candy values looking at right of current.
// The max of the two values at each index would give us the exact candy distribution
// Instead of creating the second array we can just compute max inplace and store in the same array
// Now we will take the sum of the array return it.
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int candies = 0;
        int[] candyArr = new int[n];
        candyArr[0] = 1;
        //check if cur is greater than left
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]){
                candyArr[i] = candyArr[i-1] + 1;
            }
            else{
                candyArr[i] = 1;
            }
        }
        //check if cur is greater than right
        candies = candyArr[n-1];
        for(int i = n - 2; i >=0; i--){
            if(ratings[i] > ratings[i+1]){
                candyArr[i] = Math.max(candyArr[i], candyArr[i+1]+ 1);
            }
            else{
                candyArr[i] = Math.max(candyArr[i], 1);
            }
            candies += candyArr[i];
        }
        return candies;
    }
}