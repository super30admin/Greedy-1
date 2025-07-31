/*
Time Complexity O(N)
Space Complexity O(N)
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/
import java.util.Arrays;
public class Candy_LC_135 {
    public int candy(int[] ratings) {

        int n = ratings.length;
        int[]arr = new int[n];
        //left pass
        Arrays.fill(arr,1);
        for(int i = 1; i<n; i++) {
            if(ratings[i] > ratings[i-1]) {
                arr[i] = arr[i-1] + 1;
            }
        }

        //right pass
        int sum = arr[n-1];
        for(int i = n-2; i>=0; i--) {
            if(ratings[i] > ratings[i+1]) {
                arr[i] = Math.max(arr[i], arr[i+1] +1);
            }
            sum+= arr[i];
        }
        return sum;
    }
}