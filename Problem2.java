// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1)
          return 0;
        int jumps = 1;
        int curr = nums[0];
        int next = nums[0];
        for(int i = 0; i < nums.length; i++){
            next = Math.max(next,i+nums[i]);
            if(curr == i && i!=nums.length - 1){
                jumps++;
                curr = next;
            }
        }
        return jumps;
    }
}