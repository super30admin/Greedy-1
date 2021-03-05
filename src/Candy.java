import java.util.Arrays;

/* 
 * The Time complexity of the algorithm is O(n) where n is no of elements.
 * The Space complexity of the algorithm is O(1).
 */

public class Candy {

	public int candy(int[] ratings) {

		if (ratings == null || ratings.length == 0)
			return 0;

		int[] candies = new int[ratings.length];

		Arrays.fill(candies, 1);

		// right pass

		for (int i = 1; i < ratings.length; i++) {

			if (ratings[i] > ratings[i - 1]) {

				candies[i] = candies[i - 1] + 1;

			}

		}

		// left pass

		for (int i = ratings.length - 2; i >= 0; i--) {

			if (ratings[i] > ratings[i + 1]) {

				candies[i] = Math.max(candies[i], candies[i + 1] + 1);
			}

		}

		int sum = 0;

		for (int ele : candies) {

			sum += ele;

		}

		return sum;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
