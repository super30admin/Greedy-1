import java.util.Arrays;

// Time Complexity : Add : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Candy {
    public static void main(String[] args) {
        int[] ratings = {1,2,2};
        candy(ratings);
    }

    public static int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0)
            return 0;

        int n = ratings.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);

        // left pass
        for(int i=1; i<n; i++){   // T.C - O(N)  ; S.C - O(1)
            if(ratings[i] > ratings[i-1])
                result[i] = result[i-1] + 1;
        }

        int sum = result[n-1];

        //right pass
        for(int i=n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1])
                result[i] = Math.max(result[i], result[i+1] + 1);

            sum += result[i];
        }

        return sum;
    }
}

