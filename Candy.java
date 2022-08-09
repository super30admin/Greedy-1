// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int candy(int[] ratings) {

        int n = ratings.length;
        if (n == 1) return 1;

        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        // Move from left to end -> compare only left side and give candies
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                ans[i] = ans[i - 1] + 1;
            }
        }

        // Move from right to left -> Careful :: don't change already given value if new one is min
        // to maintain relative weight
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                ans[i] = Math.max(ans[i], ans[i + 1] + 1);
            }
        }

        // array is filled
        return Arrays.stream(ans).sum();
    }
}