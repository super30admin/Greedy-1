// Time Complexity : O(n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this 

class Solution {
public:
    int jump(vector<int>& nums) {
        
        int len = nums.size();
        int count = 1;
        int jump_max = nums[0];
        int jump_cur = nums[0];
        int i = 1;
        
        while(i <= min(len-1, jump_max))
        {
            // Maximum of Max Jump or the Current available Jump value
            jump_max = max(jump_max, nums[i] + i);
            
            if(i == len-1)
                return count;
            
            if(i == jump_cur)
            {
                jump_cur = jump_max;
                count++;
            }          
            i++;
        }
        
        return 0;
    }
};