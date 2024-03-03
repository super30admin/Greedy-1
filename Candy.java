import java.util.Arrays;

public class Candy {
    // TC: O(N) where N is length of ratings
    // SC: O(N) where N is length of ratings
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += candies[i];
        }
        return res;
    }
}
