//DFS solution

// Time Complexity : exponential
// Space Complexity :
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : TLE

class Solution {
public:
    bool canJump(vector<int>& nums) {
        if(nums.size()<2){
            return true;
        }
        return dfs(nums,0);
    }
    bool dfs(vector<int>& nums, int index){
        if(index >= nums.size()-1){
            return true;
        }
        for(int i=1;i<=nums[index];i++){
            if(dfs(nums,index+i)){
                return true;
            }
        }
        return false;
    }
};

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    bool canJump(vector<int>& nums) {
        if(nums.size()<2){
            return true;
        }
        int destination = nums.size()-1;
        for(int i=nums.size()-2;i>=0;i--){
            if(nums[i]+i>=destination){
                destination = i;
            }
        }
        if(destination==0){
            return true;
        }
        return false;
    }
};
