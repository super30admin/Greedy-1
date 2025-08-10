// Time Complexity : O(N)
// Space Complexity : O(N)
import java.util.Arrays;
public class Candy {
    static int candy(int[] ratings) {
        int n = ratings.length;
        int[] ration = new int[n];

        ration[0] = 1;
        for(int i = 1; i < n; i++) {
            if(ratings[i-1] < ratings[i]) {
                ration[i] = Math.max(ration[i], ration[i-1] +1);
            } else {
                ration[i] = 1;
            }
        }

        int val = ration[n-1];
        for(int i = n-2; i >= 0; i--) {
            if (ratings[i + 1] < ratings[i]) {
                ration[i] = Math.max(ration[i], ration[i + 1] + 1);
            }
            val += ration[i];
        }
        return val;
    }
    public static void main(String[] args) {
        int[] ratings = {2,4,8,6,5,3,18,6,6,9,7};
        System.out.println("Ratings: "+Arrays.toString(ratings));
        System.out.println("Minimum number of candy required: " + candy(ratings));
    }
}