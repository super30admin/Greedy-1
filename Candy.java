// Time complexity: O(N+N) => O(N)
// Space complexity: O(N)
import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;

        int n = ratings.length;
        int [] result = new int[n];
        Arrays.fill(result, 1);
        int total = 0;

        // left to right pass to check with left neighbour
        for (int i=1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) {
                result[i] = result[i-1] + 1;
            }
        }

        // right to left pass to check with right neighbour
        for (int i=n-2; i>=0; i--) {
            if (ratings[i] > ratings[i+1]) {
                result[i]= Math.max(result[i], result[i+1] + 1);
            }
            total += result[i];
        }
        total += result[n-1];

        return total;
    }
}
