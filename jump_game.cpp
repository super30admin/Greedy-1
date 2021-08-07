// Time Complexity : O(n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Almost. Passed 154/166 tests
// Any problem you faced while coding this : Will figure out the problem for remaining tests

class Solution {
public:
    bool canJump(vector<int>& nums) {
        
        int i = 0;
        int prev = -1;
        
        int len = nums.size();
        bool flag = false;

        // Traverse till the end 
        while(i < len)
        {
            if(prev == i)
                break;

            // Only if NonZero jump   
            if(nums[i] > 0)
            {
                prev = i;
                i += nums[i];
            }
            // Zero Jump case
            else
                prev = i;

            // Exit condition            
            if(i >= len-1)
            {
                flag = true;
                break;
            }
        }

        return flag;    
    }
};