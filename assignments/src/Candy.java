// Approach: 2 pass iteration left to right and right to left
// In left pass: Compare the ratings with previous, if > increase candyCount by 1
// In right pass: Compare the ratings with next, if > candyCount of that index, its result =
// Max (existing candyCount, next's candyCount + 1)
// Time: O(n)
// Space: O(n) for result array

import java.util.Arrays;

class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 1) return 1;
        int[] result = new int[n];
        Arrays.fill(result, 1);

        // left pass
        for (int i = 1; i<n; i++) {
            if (ratings[i] > ratings[i-1]) {
                result[i] = result[i-1] + 1;
            }
        }
        int sum = result[n-1];
        // right pass
        for (int i = n-2; i>=0; i--) {
            if (ratings[i] > ratings[i+1]) {
                result[i] = Math.max(result[i], result[i+1] + 1);
            }
            sum += result[i];
        }
        return sum;
    }
}