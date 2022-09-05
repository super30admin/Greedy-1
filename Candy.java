import java.util.Arrays;

//Time Complexity:O(n)
//Space Complexity:O(n)

class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;

        int n = ratings.length;
        int[] candies = new int[n];
        // giving each child 1 candy initially.
        Arrays.fill(candies, 1);

        // check priority with left neighbor
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // checking priority with right neighbor
        int totalCandies = candies[n - 1]; // capturing the value at n-1(last value)
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            totalCandies += candies[i];
        }

        return totalCandies;

    }
}