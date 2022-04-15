// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We will find the next max possible jump from the current position
// We will keep updating the next max jump till i reaches curMax location
// In that case we would increment the jump count also resign the curMax
// to the max possible location we have computed.
// We will continue this to find our min possible jump to reach the destination
// The idea is for every possible jump we are taking best possible jump that would 
// lead us to the destination
class Solution {
    public int jump(int[] nums) {
        int curMax = 0;
        int nextMax = nums[0];
        int jumps = 0;
        for(int i = 0; i < nums.length; i++){
            nextMax = Math.max(nextMax, nums[i] + i);
            if( i >= nums.length -1)
                return jumps;
            if(curMax == i){
                curMax = nextMax;
                jumps++;
            }
        }
        return jumps;
    }
}