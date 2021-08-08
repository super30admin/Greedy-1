package Greedy1;

import java.util.Arrays;

public class Candy {
    /* Created by palak on 8/8/2021 */

    public int candy(int[] ratings) {
        if(ratings == null)     return 0;
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, -1);

        // Left Pass
        for(int i = 1 ; i < n ; i++) {
            if(ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i] + 1;
            }
        }

        //Right Pass
        int sum = candies[n-2];
        for(int i = n - 2 ; i >= 0 ; i--) {
            if(ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
            sum += candies[i];
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
