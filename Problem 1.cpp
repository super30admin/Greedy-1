//Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
public:
    bool canJump(vector<int>& nums) {
        if(nums.size()<2) return true;
        int dest = nums.size()-1;
        for(int i=nums.size()-2; i>=0; i--){
            if(i+nums[i]>=dest){
                dest = i;
            }
        }
        
        if(dest==0) return true;
        
        return false;
    }
};