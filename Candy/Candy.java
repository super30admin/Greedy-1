/* Time Complexity : O(2n) ~ O(n)
 *   n - length of array - ratings */
/* Space Complexity : O(n) */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        //compare with left neighbors
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i - 1]){
                res[i] = res[i-1] + 1;
            }
        }
        int sum = res[n-1];
        //compare with left neighbors and calc sum
        for(int i = n-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                res[i] = Math.max(res[i], res[i+1] + 1);
            }
            sum += res[i];
        }
        return sum;
    }
}