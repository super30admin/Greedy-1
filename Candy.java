import java.util.Arrays;

// TC: O(n) two passes are performed from start to end and vice versa. which contributes to O(n)
// SC: O(n) candies array contributes space

// Runs successfully on leetcode
// In the first pass, element greater than the previous fills candies array with correct amount.
// in the reverse pass, element greater on the right takes care of the candies and sum together.
public class Candy {

    public static void main(String[] args) {
        System.out.println(candy(new int[] { 1, 0, 2 })); // 5
        System.out.println(candy(new int[] { 1, 2, 2 })); // 4
    }

    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;

        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        int sum = candies[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            sum += candies[i];
        }
        return sum;
    }
}