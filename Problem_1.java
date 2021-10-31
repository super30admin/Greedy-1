// Time Complexity : O(2n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// fill the result array with 1, go from 0 to n-1 and consider the left neighbour only, then go to n-1 to 0 and consider the right neighbour only.
// Your code here along with comments explaining your approach
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int [] result = new int [n];
        Arrays.fill(result, 1);
        int sum = 0;
        for(int i = 1; i < n ; i++){
            if(ratings[i] > ratings[i-1]){
                result[i] = result[i-1] + 1;
            }
        }
        sum = result[n-1];
        for( int i = n-2; i >=0; i--){
            if(ratings[i] > ratings[i+1]){
                result[i] = Math.max(result[i], result[i+1]+1);
            }
            sum += result[i];
        }
        return sum;
    }
}