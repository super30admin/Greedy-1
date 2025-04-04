// Problem3 Candy (https://leetcode.com/problems/candy/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, try to add candies during pass from left to right according to left candidate is greater or not. In the second pass add candies
 * according to right elements. After passes add all the elements in the result array and return total candies.
 */
class Solution {
    public int candy(int[] ratings) {
        int []result = new int[ratings.length];
        Arrays.fill(result, 1);
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
                result[i] = result[i-1] + 1;
            }
        }
        int total = result[result.length-1];
        for(int i =  ratings.length-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                result[i] = Math.max(result[i], result[i+1]+1);
            }
            total += result[i];
        }
        return total;
    }
}