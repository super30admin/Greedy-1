// Time Complexity : O(n) as we are travelling throught the array only once
// Space Complexity : O(1) we are not creating any space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning


class Solution {
public:
    int canJump(vector<int>& nums) {
        if(nums.size() == 0){
            return true;
        }
        
        int final_index = nums.size() -1;
        
        
        for ( int i = nums.size()-2; i >= 0; i-= 1){
            
            if(nums[i] + i >= final_index){
                final_index = i;
            }
            
        }
        
        return final_index == 0;
    }
};