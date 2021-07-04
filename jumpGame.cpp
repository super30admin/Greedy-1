// Time Complexity :O(n) where n in the number elements in the vector
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    bool canJump(vector<int>& nums) {
        int destination = nums.size()-1;
        int jumps;
        for(int  i = nums.size()-2; i >= 0 ; i--){
            jumps= nums[i];
            for(int jump = 1;jump <= jumps;jump++){
                if(i + jump == destination)
                    destination = i;
            }
        }
        return destination == 0;
    }
};