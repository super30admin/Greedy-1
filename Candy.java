// Approach :
// Track the slope of the ratings (increasing, decreasing, or flat).

// Use variables up and down to count lengths of increasing and decreasing sequences.

// When a change in slope is detected (like from increasing to flat/decreasing), calculate total candies from the previous hill/valley using arithmetic sums.

// Add contributions of remaining slope sequence after the loop ends.

// Time Complexity:
// O(n) — One pass through the ratings array.

// Space Complexity:
// O(1) — Only constant extra space is used (up, down, oldSlope, etc.).

public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n <= 1)
            return n;

        int up = 0, down = 0, oldSlope = 0;
        int total = 1; // The first child gets 1 candy.

        for (int i = 1; i < n; i++) {
            int newSlope = Integer.compare(ratings[i], ratings[i - 1]); // +1, 0, or -1

            if ((oldSlope > 0 && newSlope == 0) || (oldSlope < 0 && newSlope >= 0)) {
                // When slope changes from up->flat/down or down->flat/up, 
                // we add the segment contribution
                total += getTotal(up) + getTotal(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }

            if (newSlope > 0) {
                up++;
            } else if (newSlope < 0) {
                down++;
            } else {
                total += 1; // flat rating, just 1 candy
            }

            oldSlope = newSlope;
        }

        // Add the last segment
        total += getTotal(up) + getTotal(down) + Math.max(up, down);

        return total;
    }

    // Arithmetic sum: 1 + 2 + ... + n
    private int getTotal(int n) {
        return n * (n + 1) / 2;
    }
}

// -----------------------------------------------------------------------------------------------------------------------
// Time Complexity : O(n) — Two linear passes (left-to-right and right-to-left)
// Space Complexity : O(n) — Extra array 'dp' of size n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// - Optional early increment of dp[0] may be unnecessary, handled in the loop.
// - Clearer logic can be maintained by removing that early conditional.
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n < 2) return 1; // Only one child, give 1 candy

        int[] dp = new int[n]; // dp[i] represents candies for child i
        int sum = 0;
        Arrays.fill(dp, 1); // Every child gets at least one candy

        // Left to Right: ensure higher rated child gets more than left neighbor
        for (int i = 1; i < n; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        // Right to Left: ensure higher rated child gets more than right neighbor
        for (int i = n - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1]) {
                dp[i] = Math.max(dp[i], dp[i + 1] + 1);
            }
            sum += dp[i + 1]; // Sum right to left (i+1)
        }

        // Add the first child's candy count
        sum += dp[0];

        return sum;
    }
}

