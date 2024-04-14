// TC: O(n)
// SC: O(n)

// Approach: Start giving out candy from the lowest rating 
// Give out more candies with respect to left neighbor first
// and then with right neighbor. Take the max.

import java.util.Arrays;

class Candy {
    public int candy(int[] ratings) {
        int result = 0;
        int[] candyArr = new int[ratings.length];
        Arrays.fill(candyArr, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candyArr[i] = candyArr[i - 1] + 1;
            }
        }

        result += candyArr[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candyArr[i] = Math.max(candyArr[i], candyArr[i + 1] + 1);
            }
            result += candyArr[i];
        }

        return result;
    }
}