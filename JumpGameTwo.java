// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


public class JumpGameTwo {
    class Solution {
        public int jump(int[] nums) {
            int n = nums.length;
            if(n == 1)
                return 0;
            int currInt = nums[0];
            int nextInt = nums[0];
            int minJumps = 1;

            for(int i = 1; i < n; i++){
                if(i == currInt + 1){
                    minJumps++;
                    currInt = nextInt;
                }
                nextInt = Math.max(nextInt, i + nums[i]);
            }
            return minJumps;
        }
    }
}
