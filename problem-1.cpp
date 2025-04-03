// https://leetcode.com/problems/jump-game/description/

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public:
        bool canJump(vector<int>& nums) {
            int n = nums.size();
            int tar = 0;
            for(int i=0; i<n; i++){
                if(i > tar) return false;
                if(tar == n-1) return true;
                tar = max(tar, i+nums[i]);
            }
            return true;
        }
    };
    
// traversing from the back

class Solution {
    public:
        bool canJump(vector<int>& nums) {
            int n = nums.size();
            int tar = n-1;
            for(int i=n-2; i>=0; i--){
                if(i+nums[i] >= tar) tar = i;
            }
            return tar == 0;
        }
    };