// Time Complexity : O(n)
// Space Complexity :O91
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int curr = n-1;
        int prev = n;
        
        boolean result = false;
        
        if(n==0 || nums == null){
            return false;
        }
        
        if(n==1){
            return true;
        }
        
        for(int i=n-2;i>=0;i--){
            prev = i;
            if(prev+nums[prev]>=curr){
                result = true;
            }else{
                result = false;
            }
            
            //keepgoing
            if(result){
                curr = prev;
            }
        }
        
        return result;
    }
}