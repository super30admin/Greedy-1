// Time complexity - O(n)
//space complexity -O(n)
// solved on leetcode - yes
// Faced any issues - No
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1); // Every child gets at least one candy

        // Left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Sum all candies
        int total = 0;
        for (int candy : candies) {
            total += candy;
        }

        return total;
    }
}
