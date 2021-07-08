// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : followed from class

// Your code here along with comments explaining your approach
//keep variables maxSteps and maxNextInterval, to keep track of maxSteps we can take before making a jump and update maxNextInterval 
// to indicate max index coverable from this point, when maxSteps reaches the end of array return number of jumps 


class Solution {
    public int jump(int[] nums) {
        
        if(nums==null || nums.length<2)
            return 0;
        
        int n = nums.length;
        int maxNextInterval = nums[0];
        int maxSteps = nums[0];
        
        int jumps = 1;
        for(int i=1; i<n; i++){
            if(i>maxSteps){
                jumps +=1;
                maxSteps = maxNextInterval;
            }
            
            if(maxSteps>=n-1){
                break;
            }
            
            maxNextInterval = Math.max(maxNextInterval, nums[i]+i);
        }
        
        return jumps;
    }
}