// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int jump(int[] nums) {
        if(nums==null || nums.length==0 || nums.length==1)
            return 0;
        
        int currInterval = nums[0];
        int nextInterval = nums[0];
        
        int jump = 1;
        
        for(int i=1; i< nums.length; i++){
            nextInterval = (i + nums[i]) > nextInterval ? (i+ nums[i]) : nextInterval;
            
            if(i== currInterval && i!= nums.length-1){
               jump += 1;
                currInterval = nextInterval;                
            }
            
            if(currInterval >= nums.length-1){
                break;
            }
        }
        return jump; 
    }
}