import java.util.Arrays;

// Time Complexity : O(n) where n = length of ratings array
// Space Complexity : O(n) where n = length of ratings array
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//135. Candy (Hard) - https://leetcode.com/problems/candy/
//Time Complexity : O(n) where n = length of ratings array
// Space Complexity : O(n) where n = length of ratings array
class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        
        int n = ratings.length;
        if (n == 1) return 1;
        
        int[] result = new int[n]; // O(n)
        Arrays.fill(result, 1);
        
        // forward pass
        for (int i = 1; i < n; i++) { // O(n)
            if (ratings[i] > ratings[i-1]) {
                result[i] = 1 + result[i-1];
            }
        }
        
        int sum = result[n-1];
        // backward pass
        for (int i = n-2; i >= 0; i--) { // O(n)
            if (ratings[i] > ratings[i+1]) {
                result[i] = Math.max(result[i], 1 + result[i+1]);
            }
            sum+= result[i];
        }
        
        return sum;
    }
}