import java.util.Arrays;

public class Candy {
	public int candy(int[] ratings) {

		if (ratings == null || ratings.length == 0)
			return 0;

		int[] result = new int[ratings.length];
		Arrays.fill(result, 1);
		int sum = 0;

		for (int i = 1; i < ratings.length; i++) {

			if (ratings[i] > ratings[i - 1]) {

				int val = result[i - 1];
				result[i] = val + 1;
			}

		}

		for (int j = ratings.length - 2; j >= 0; j--) {

			if (ratings[j] > ratings[j + 1]) {
				int val = result[j + 1];
				result[j] = val + 1;
			}

		}

		for (int rs : result) {
			sum += rs;
		}
		return sum;

	}

	public static void main(String[] args) {
		Candy c = new Candy();
		c.candy(new int[] { 1, 3, 4, 5, 2 });
	}
}
