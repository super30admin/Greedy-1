// Time Complexity :O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
public class JumpGame {
    class Solution {
        public boolean canJump(int[] nums) {
            int lastGoodIndexPos = nums.length-1;//keep track of last known good index to jump to

            //iterate over array and check if i + nums at index is greater than or equal to last good pos index
            for (int i = nums.length-1; i >=0 ; i--) {
                if(i + nums[i] >= lastGoodIndexPos) lastGoodIndexPos = i;
            }
            return lastGoodIndexPos == 0;//if index is at 0 then at the end, else unable to jump from start to end
        }
    }
}
