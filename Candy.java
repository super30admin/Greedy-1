/*
 * TC: O(n)
 * SC: O(n)
 */
public class Candy {
    public int candy(int[] ratings) {
        int l = ratings.length;
        if (l == 0 || l == 1) return l;
        int i;
        int[] candy = new int[l];
        candy[0] = 1;
        for (i = 1; i < l; i++) {
            // children with higher ratings should get
            // more candies than their right neighbours
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = 1 + candy[i - 1];
            }
            // each child must get at least one candy
            else {
                candy[i] = 1;
            }
        }
        // now go backwards to make sure that each child
        // with a higher rating than their left neighbour
        // also has more candy than their left neighbours
        for (i = l - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]) {
                candy[i] = 1 + candy[i + 1];
            }
        }
        // now sum up the total candies required
        int total = 0;
        for(int c: candy) {
            total += c;
        }
        return total;
    }
}
