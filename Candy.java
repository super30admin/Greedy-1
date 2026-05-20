import java.util.Arrays;

/**
 * Greedy two-pass solution: first pass ensures higher-rated children get more candies than the left neighbor,
 * second pass ensures the same condition for the right neighbor while preserving previous assignments.
 * Time Complexity: O(n), Space Complexity: O(n)
 */

public class Candy {
        public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = n-2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int count = 0; 

        for(int i : candies) {
            count += i;
        }

        return count;
    }
    
}
