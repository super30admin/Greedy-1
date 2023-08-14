import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        int sum = candies[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            sum += candies[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Candy candy = new Candy();

        int[] ratings1 = { 1, 0, 2 };
        System.out.println("Total candies (ratings1): " + candy.candy(ratings1));

        int[] ratings2 = { 1, 2, 2 };
        System.out.println("Total candies (ratings2): " + candy.candy(ratings2));

        int[] ratings3 = { 1, 2, 87, 87, 87, 2, 1 };
        System.out.println("Total candies (ratings3): " + candy.candy(ratings3));
    }
}
