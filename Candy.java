// Time Complexity: O(2n)
// Space Complexity: O(n)

import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        // [3, 5, 4, 2, 1, 0, 9, 11, 14, 6, 2, 5, 12, 20]
        // [1, 5, 4, 3, 2 ,1, 2, 3, 4, 2, 1, 2, 3, 4]

        int n = ratings.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1])
                result[i] = result[i - 1] + 1;
        }

        int total = result[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                result[i] = Math.max(result[i], result[i + 1] + 1);
            total += result[i];
        }

        return total;
    }
}