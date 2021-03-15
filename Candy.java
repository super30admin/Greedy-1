import java.util.Arrays;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
public class Candy {
    class Solution {
        public int candy(int[] ratings) {
            if(ratings.length == 0) return 0;//no ratings thus no candy to pass out

            int[] candy = new int[ratings.length];
            Arrays.fill(candy, 1);//give everyone candy

            //check from left to right for children that should be given additional candy
            for (int i = 1; i < ratings.length; i++) {
                if(ratings[i] > ratings[i-1]) candy[i] = candy[i-1]+1;
            }

            //check from right to left for children that should be given additional candy
            for (int i = ratings.length-2; i >= 0 ; i--) {
                if(ratings[i] > ratings[i+1]) candy[i] = Math.max(candy[i], candy[i+1]+1);
            }

            //sum up all candies and return the value
            int sum=0;
            for(int c:candy){
                sum += c;
            }
            return sum;
        }
    }
}
