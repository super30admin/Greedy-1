// Time Complexity :O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
public class JumpGameII {
    class Solution {
        public int jump(int[] nums) {
            if(nums == null || nums.length < 2) return 0;//base case

            int jumps=0, curEnd=0, curFarthest=0;

            //iterate over array from left to right and determine the min number of jumps by storing the max distance at
            //each iteration in the curFarthest variable and then incrementing when i is equals to curEnd variable and
            //updating that variable
            for (int i = 0; i < nums.length-1; i++) {

                curFarthest = Math.max(curFarthest, nums[i]+i);
                if(i == curEnd){
                    jumps++;
                    curEnd = curFarthest;
                }
            }
            return jumps;//return min number of jumps
        }
    }
}
