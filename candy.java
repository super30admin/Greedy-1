// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 * Assign 1 candy to all the children.
 * Iterate form left to right and assign a candy to curr child based on left child.
 * Iterate form right to left and assign a candy to curr child based on right child.
 * Sum all the candies and return.
 */

import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);

        for(int i=1; i<n; i++){
            if(ratings[i] > ratings[i-1]){
                result[i] = result[i-1] + 1;
            }
        }

        for(int i=n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                result[i] = Math.max(result[i], result[i+1] + 1);
            }
        }

        int sum = 0;
        for(int res : result)
            sum += res;

        return sum;
    }
}