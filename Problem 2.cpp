//Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
public:
    int jump(vector<int>& nums) {
        if(nums.size()<2) return 0;
        int jumps=1;
        int end = nums.size()-1;
        int currInterval = nums[0];
        int nextInterval = nums[0];
        
        for(int i=1; i<nums.size(); i++){
            nextInterval = max(nums[i]+i, nextInterval);
            if(i<nums.size()-1 && i==currInterval){
                jumps++;
                currInterval = nextInterval;
            }
        }
        
        return jumps;
       
    }
};