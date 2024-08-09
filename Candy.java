// Time Complexity : O(n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, had to learn

/*
 * Problem# :135 Candy
 * 
 * We can use stack to solve it too, but this is optimal
 * 
 * on the first pass 0->n
 * check if the current number is greater than the left neighbor (start from 1)
 * if it is , add 1 to result[i] ; ie. give one candy more to i because he has greater rating than left neighbor
 * 
 * on the second pass n->0
 * check if the current number is greater than the right neigbor
 * if it is result[i] would be Max(result[i+1]+1 , result[i]); 
 * i.e., give one candy to i because he is greater rating than right neigbor 
 * or 
 * if the result[i] is greater than result[i+1]+1, ie., resolve by the first pass, keep as is because the condition is already met
 * 
 * return the total
 */

import java.util.*;

public class Candy {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);

        for (int i = 1; i < n; i++) {
            // left neighbor
            if (ratings[i] > ratings[i - 1]) {
                result[i] = result[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            // right neigbhor
            if (ratings[i] > ratings[i + 1]) {
                result[i] = Math.max(result[i + 1] + 1, result[i]);// take which ever max, either through right neigbor
                                                                   // or left neighbor result
            }
        }

        int sum = 0;

        for (int i : result) {
            sum += i;
        }

        return sum;
    }

}
