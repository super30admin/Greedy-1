// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach

class Solution {
    public int jump(int[] nums) {
        // Breath first approach along with greedy technique
        
        // Evaluate first number in the array and length of its value is the scope of the first level in Breath First search.
        //  At each point evaluate if ths can reach the farthest position in the array
        
        int jump = 0, scope = 0, farthestReach = 0;
        if(nums.length == 1)
            return jump;
        
        for(int i=0; i<nums.length-1;i++){
            farthestReach = Math.max(farthestReach, nums[i] + i);  // Check if current element + index reaches the maximum value.
            if(farthestReach >= nums.length -1)  
                return jump + 1;                              //If so return jump + 1 as we start from 0, +1 includes the last jump made
            
            if(scope == i ){                      // To validate the reach of each level we maintain a scope, if index reaches the scope increment the jump and 
                                                  // Update the scope with maximum value reachable level as the next starting value.
                jump++;
                scope = farthestReach;
            }
        }
        
        return jump+1;
    }
}
