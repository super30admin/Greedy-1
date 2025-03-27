// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int candy(int[] ratings) {
        int sum = 1;
        int peak, down;
        int i = 1;
        while (i < ratings.length) {
            if (ratings[i] == ratings[i - 1]) {
                sum += 1;
                i++;
                continue;
            }
            peak = 1;
            while (i < ratings.length && ratings[i] > ratings[i - 1]) {
                peak += 1;
                sum += peak;
                i++;
            }
            down = 1;
            while (i < ratings.length && ratings[i] < ratings[i - 1]) {
                sum += down;
                down += 1;
                i++;
            }
            if (down > peak)
                sum += down - peak;
        }
        return sum;
    }
}