// Time Complexity: O(N)
// Space Complexity: O(1)

import java.util.*;

class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length < 2)   return true;
        
        int dest = nums.length-1;
        for(int i=nums.length-2; i >=0; i--)
        {
            if(i+nums[i]>=dest)
                dest=i;
        }
        return dest==0;
    }
}