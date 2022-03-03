package greedy1;

import java.util.Arrays;

public class Candy {
	//Time Complexity : O(n), where n is the size of nums
	//Space Complexity : O(n)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        Arrays.fill(res, 1);
        
        for(int i=1; i<ratings.length; i++) {
            if(ratings[i] > ratings[i-1])
                res[i] = Math.max(res[i-1] + 1, res[i]);
        }
        
        int sum = res[ratings.length - 1];
        for(int i=ratings.length - 2; i>=0 ; i--) {
            if(ratings[i] > ratings[i+1])
                res[i] = Math.max(res[i+1] + 1, res[i]);
            sum += res[i];
            
        }
        
        return sum;
    }
}
