// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Main {

    public static int candy(int[] ratings) {
        // null case
        if (ratings == null || ratings.length == 0)
            return 0;
        if (ratings.length == 1)
            return 1;
        int n = ratings.length;
        int[] result = new int[n];
        // fill result with 1
        Arrays.fill(result, 1);
        // forward pass
        // in forward pass if incoming rating is greater than the previous
        // rating I will give 1 more candy than the pervious one
        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] < ratings[i]) {
                result[i] = result[i - 1] + 1;
            }
        }

        // for sum the total candies
        int sum = result[n - 1];
        // backward pass
        // in backward pass I will do the same thing as forward pass
        // but I will also check if child has already more candies then
        // I will not make changes
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                result[i] = Math.max(result[i], result[i + 1] + 1);
            }
            sum += result[i];
        }
        return sum;

    }

    public static void main(String[] args) {
        int[] ratings = new int[] { 1, 2, 87, 87, 87, 2, 1 };
        System.out.println(candy(ratings));
    }
}