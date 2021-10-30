// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0)
            return 0;
        if(ratings.length < 2)
            return 1;
        int n = ratings.length;
        int[] result = new int[n];
        int sum = 0;
        Arrays.fill(result, 1);
        // left pass
        for(int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i - 1])
                result[i] = result[i - 1] + 1;
        }
        // right pass
        sum = result[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1])
                result[i] = Math.max(result[i], result[i + 1] + 1);
            sum = sum + result[i];
        }
        return sum;
    }
}