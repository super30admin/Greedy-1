// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, optimal solutiom with slope need to revisit


// Your code here along with comments explaining your approach
// we can do two passes, one from left to right and one from right to left
// in the left to right pass, we check if the current rating is greater than the previous rating, if yes then we need to give one more candy than the previous index
// in the right to left pass, we check if the current rating is greater than the next rating, if yes then we need to give one more candy than the next index, but we also need to take the maximum of the current candy and the candy needed for the next index, because we need to satisfy both conditions
// at the end we need to sum up all the candies needed and return the count 
// we can also do it in one pass by keeping track of the current slope,
//  if the slope is positive then we need to give one more candy than the previous index, 
// if the slope is negative then we need to give one more candy than the next index,
//  but we also need to take the maximum of the current candy and the candy needed for the next index,
//  because we need to satisfy both conditions, if the slope is zero then we need to give one candy

class Solution {

    public int candy(int[] ratings) {

        int n = ratings.length;

        int[] candies = new int[n];

        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        // Left to right pass
        for (int i = 1; i < n; i++) {

            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to left pass
        for (int i = n - 2; i >= 0; i--) {

            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i],
                                      candies[i + 1] + 1);
            }
        }

        int count = 0;

        for (int num : candies) {
            count += num;
        }

        return count;
    }
}