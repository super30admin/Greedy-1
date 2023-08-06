// Time Complexity : O(n) where n is the length of the ratings array
// Space Complexity :O(1) no auxiliary space used
// Did this code successfully run on Leetcode :yes
import java.util.Arrays;
public class Candy {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length < 1){
            return 0;
        }
        int n = ratings.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        int sum = 0;
        //forward pass
        for(int i = 1; i<n; i++){
            if(ratings[i] > ratings[i-1]){
                result[i] = result[i-1] +1;
            }
        }

        //backward pass
        for(int i = n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                result[i] = Math.max(result[i], result[i+1]+1);
            }
            sum += result[i];
        }
        sum += result[n-1];
        return sum;
    }
}
