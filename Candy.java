//TC- O(n)
//SC - O(1)
import java.util.Arrays;

public class Candy {
	public int candy(int[] ratings) {
		int[] result = new int[ratings.length];
		Arrays.fill(result, 1);
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1])
				result[i] = result[i - 1] + 1; // use result i-1 for comparison
		}
		int candies = result[ratings.length - 1];
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				result[i] = Math.max(result[i], result[i + 1] + 1); // use result for comparison
			}
			candies = candies + result[i];
		}
		return candies;
	}

	public static void main(String[] args) {
		int[] ratings = { 1, 2, 87, 87, 87, 2, 1 };
		Candy c = new Candy();
		System.out.println(c.candy(ratings));
	}

}
