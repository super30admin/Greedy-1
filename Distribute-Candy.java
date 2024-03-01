// Time Complexity : O(2N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using Greedy, firstly distribute 1 candy for all kids.
// 2 pass solution - start from left by checking if left neighbor has higher rating and increase
// curr candy. Right pass - check if right neighbor has higher rating compared to curr and do max+1.

// 135. Candy

import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int [] res = new int[n];
        Arrays.fill(res,1);
        for(int i=1;i<n;i++){
            if(ratings[i] > ratings[i-1]){
                res[i] = res[i-1] + 1;
            }
        }
        int sum = res[n-1];
        for(int i=n-2;i>=0;i--){
            if(ratings[i] > ratings[i+1]){
                res[i] = Math.max(res[i],res[i+1]+1);
            }
            sum += res[i];
        }
        return sum;
    }
}