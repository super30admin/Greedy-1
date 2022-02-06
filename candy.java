// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We traverse twice, from left to right to check for the previous element and from right to left for next element is bigger
class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int n = ratings.length;
        int[] candy = new int[n];
        Arrays.fill(candy, 1);

        // Checking Left elements
        for (int i=1; i<n; i++) {
            if (ratings[i] > ratings[i-1]) {
                candy[i] = candy[i-1]+1;
            }
        }

        // Checking Right elements
        int sum = candy[n-1];
        for (int i=n-2; i>=0; i--) {
            if (ratings[i] > ratings[i+1]) {
                candy[i] = Math.max(candy[i], candy[i+1]+1);
            }
            sum += candy[i];
        }

        return sum;
    }
}