
import java.util.Arrays;

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int destination = n-1;
        for(int i = n-2; i >= 0; i--) {
            if(i + nums[i] >= destination)
                destination = i;
        }
        return (destination == 0);
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution2 {
    public int jump(int[] nums) {
        int currInt = nums[0];
        int nextInt = nums[0];
        if(nums.length < 2) return 0;
        int jumps = 1;
        for(int i = 1; i < nums.length; i++) {
            nextInt = Math.max(nextInt, i + nums[i]);
            if(i == currInt && i != nums.length-1) {
                jumps++;
                currInt = nextInt;
            }
        }
        return jumps;
    }
}


// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution3 {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        
        for(int i = 1; i < n; i++)
            if(ratings[i] > ratings[i-1])
                candies[i] = candies[i-1] + 1;
        
        int sum = candies[n-1];
        for(int i = n-2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1])
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            sum += candies[i];
        }
        
        return sum;
    }
}