/*
TC = O(n) - single pass
SC - O(1) - constant since no other storage used other than local vars
Difficulties - no, this one makes sense to me now. We keep pushing the max known limit and if we cross it, then
we have to be at the ending, or else there IS no way to get there
LeetCode Run - Yes, optimal beats 100% of other submissions on runtime.


*/

class Solution {
    public:
        bool canJump(vector<int>& nums) {
    
            int maxJumpSoFar = 0;
            int n = nums.size();
            for (int i = 0 ; i < n ; i++) {
                //code for jump game I
                if (i > maxJumpSoFar) {
                    return false;
                }
    
                if (i == n - 1) {
                    return true;
                }
            
                maxJumpSoFar = max(maxJumpSoFar, i + nums[i]);
                
            }
    
            return true;
            
        }
    };
