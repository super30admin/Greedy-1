package Greedy1;

import java.util.Arrays;
//Time complexity : O(n)
//Space complexity: O(1)
public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int res[] = new int[n];
        Arrays.fill(res, 1);
        for(int i=1; i<n; i++){
            if(ratings[i-1] < ratings[i]){
                res[i] = res[i-1] + 1;
            }
        }
        int total = res[n-1];
        for(int i=n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                res[i] = Math.max(res[i], res[i+1] + 1);
            }
            total += res[i];
        }
        return total;
    }
}
