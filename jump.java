/*
  Time : O(n)
  Space:O(1)
  Run on LeetCode: yes
*/
class Solution {
    //reverse the tree. and walk back from dest to first.
    public boolean canJump(int[] nums) {
        int dest = nums.length -1;
        for(int i = nums.length -2; i >= 0 ; i--){
            if(i+nums[i] >= dest)
                dest = i;
        }
        return dest == 0;
    }
}
