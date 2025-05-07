import java.util.Arrays;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * 1. Assign candies based on all left neighbors
 * 2. Assign candies based on max between all neighbors and candies obtained from 1st step
 * 3. Get the sum of all candies
 */

public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = 1 + candies[i-1];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], 1 + candies[i+1]);
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += candies[i];
        }

        return sum;
    }
    public static void main(String[] args) {
        // Your code here
    }
}