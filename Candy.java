// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

// We use an auxillary array 'result' initially filled with all 1s
// We traverse from left to right and assign result[i - 1] + 1 if the ith rating is more than i - 1 th rating
// Similarly we traverse right to left and assign Max(result[i], result[i + 1] + 1)
// Add the sum of all elements in result array and return the total

class Solution {
    public int candy(int[] ratings) {
        
        if(ratings == null || ratings.length == 0) {
            return 0;
        }
        
        int[] result = new int[ratings.length];
        Arrays.fill(result, 1);
        
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i - 1]) {
                result[i] = result[i - 1] + 1;
            }
        }
        
        for(int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                result[i] = Math.max(result[i], result[i + 1] + 1);
            }
        }
        
        int total = 0;
        
        for(int num : result) {
            total += num;
        }
        return total;
    }
}