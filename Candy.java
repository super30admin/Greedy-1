// Time Complexity: O(n) where n is the length of the ratings array
// Space Complexity: O(n) for the result array

import java.util.Arrays;

class Candy {
    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        Arrays.fill(res, 1);

        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
                res[i] = 1 + res[i-1];
            }
        }

        int n = ratings.length;
        int sum = res[n-1];
        for(int i = n-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                res[i] = Math.max(res[i], 1 + res[i+1]);
            }
            sum += res[i];
        }

        return sum;
    }
}