
// Time complexity : O(n)
// Space complexity : O(n)
import java.util.Arrays;

class Candy {
    public static void main(String[] args) {
        int[] ratings = { 1, 2, 2 };
        int minCandy = candy(ratings);
        System.out.println(minCandy);
    }

    private static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;
        int[] result = new int[ratings.length];
        Arrays.fill(result, 1);
        // forward pass
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                result[i] = result[i - 1] + 1;
            }
        }
        int sum = result[ratings.length - 1];
        // backward pass
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                result[i] = Math.max(result[i], result[i + 1] + 1);
            }
            sum += result[i];
        }

        return sum;
    }
}