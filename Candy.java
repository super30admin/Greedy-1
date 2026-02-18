// Time Complexity : O(2n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Allot 1 candy min to all children
// check the left neighbours for increase (checking upward slope)
// check right neighbours in reverse and increase only if required (math.max) (checking downward slope)
//  calculate sum

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int candies = 0;
        int[] lot = new int[n];
        Arrays.fill(lot, 1);

        for (int i = 1; i < n; i++)
            if (ratings[i] > ratings[i - 1])
                lot[i] = lot[i - 1] + 1;

        for (int i = n - 2; i >= 0; i--)
            if (ratings[i] > ratings[i + 1])
                lot[i] = Math.max(lot[i + 1] + 1, lot[i]);

        for (int c : lot)
            candies += c;
        return candies;
    }
}