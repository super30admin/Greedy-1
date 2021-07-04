// Time Complexity :O(n) where n in the number elements in the vector
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int jump(vector<int>& nums) {
        if(nums.size() == 1) return 0;
        pair<int,int> interval = {0,0};
        int maxReach = -1;
        int jump = 0;
        while(true){
            jump++;
            for(int  i = interval.first; i <=interval.second;i++){
                maxReach = max(maxReach, i + nums[i]);
            }
            if(maxReach >= nums.size()-1) return jump;
            interval = {interval.second+1,maxReach};
        }
        assert(jump);
    }
};