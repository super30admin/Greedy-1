//  Time Complexity: O(n)
//  Space Complexity: O(n)

import java.util.*;

public class Candy {
    public int candy(int[] ratings) {
        int[] ar = new int[ratings.length];
        Arrays.fill(ar, 1);

        //  One pass for left neighbors
        for (int i = 1; i < ratings.length; ++i) {
            if (ratings[i] > ratings[i-1]) {
                ar[i] = ar[i-1] + 1;
            }
        }

        int sum = ar[ar.length - 1];

        //  Two pass for right neighbors
        for (int i = ratings.length - 2; i >= 0 ; --i) {
            if (ratings[i] > ratings[i+1]) {
                ar[i] = Math.max(ar[i], ar[i+1] + 1);
            }

            sum += ar[i];
        }

        return sum;
    }
}
