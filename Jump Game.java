// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public boolean canJump(int[] nums) {
        int destination= nums.length-1;
        
        for(int i=nums.length-2;i>=0;i--){
            if(i+nums[i] >=destination){
                destination=i;
            }
        }

        return destination==0;
    }
}