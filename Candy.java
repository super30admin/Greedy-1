// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class Candy {
    class Solution {
        public int candy(int[] ratings) {
            int n = ratings.length;
            int result = 0;
            int[] temp = new int[n];
            Arrays.fill(temp, 1);

            for(int i = 1; i < n; i++){
                if(ratings[i] > ratings[i-1]){
                    temp[i] = temp[i-1] + 1;
                }
            }

            result += temp[n-1];
            for(int i = n-2; i >= 0; i--){
                if(ratings[i] > ratings[i+1]){
                    temp[i] = Math.max(temp[i], temp[i+1]+1);
                }
                result += temp[i];
            }

            return result;
        }
    }
}
