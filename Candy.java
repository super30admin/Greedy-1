import java.util.Arrays;

public class Candy {

    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public int candy(int[] ratings) {

        int[] dp = new int[ratings.length];

        Arrays.fill(dp, 1);

        for(int i = 1; i< ratings.length; i++){
            if(ratings[i-1] < ratings[i]){
                dp[i] = dp[i-1]+1;
            }
        }

        for(int i = ratings.length - 2; i>=0; i--){
            if(ratings[i+1] < ratings[i]){
                dp[i] = Math.max(dp[i], dp[i+1]+1);
            }
        }

        int sum=0;

        for(int i = 0; i< dp.length; i++){
            sum+=dp[i];
        }
        return sum;

    }
}
