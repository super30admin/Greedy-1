// Time Complexity : o(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : yes

class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(i+nums[i]>=lastPos){
                lastPos=i;
            }
        }
        return lastPos==0;
        
    }
}