// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We maintain old and new slopes to identify increasing and decreasing sequencies of ratings.When a slope change
breaks peak or valley, we update the up, down values and compute total candies using mathemetical formula, if
not we evenly ditribute each candy to each person. At the end, we compute total candies again for the people
around the slopes.
 */
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int oldSlope = 0 , newSlope = 0;
        int up = 0, down = 0;
        int totalCandies = 0;

        for(int i = 1 ; i < n ; i++) {
            if (ratings[i] > ratings[i - 1])
                newSlope = 1;
            else if (ratings[i] < ratings[i - 1])
                newSlope = -1;
            else
                newSlope = 0;

            if ((oldSlope < 0 && newSlope >= 0) || (oldSlope > 0 && newSlope == 0)) {
                totalCandies += count(up) + count(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }

            if(newSlope == 1) {
                up++;
            }
            else if (newSlope == -1)
                down++;
            else
                totalCandies++;

            oldSlope = newSlope;
        }
        totalCandies += count(up) + count(down) + Math.max(up, down);
        return totalCandies + 1;
    }

    private int count(int n) {
        return n * (n + 1) / 2;
    }
}