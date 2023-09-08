// Time Complexity : O(2n) -> O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] result = new int[n];
        Arrays.fill(result,1);

        for(int i=1; i<n; i++)
        {
            if(ratings[i] > ratings[i-1])
            {
                result[i] = result[i-1]+1;
            }
        }
        int sum = result[n-1];
        for(int i=n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                result[i] = Math.max(result[i],result[i+1]+1);
            }
            sum += result[i];
        }
        return sum;
    }
}
