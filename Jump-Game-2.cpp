// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

class Solution {
public:
    int jump(vector<int>& nums) {
        if(nums.size()<2){
            return 0;
        }
        int jump=1, currInt = nums[0], nextInt = nums[0];
        for(int i=1;i<nums.size()-1;i++){
            nextInt = max(nextInt, i+nums[i]);
            if(i==currInt){
                jump++;
                currInt = nextInt;
            }
        }
        return jump;
    }
};
