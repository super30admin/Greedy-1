// https://leetcode.com/problems/jump-game-ii/description/

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public:
        int jump(vector<int>& nums) {
            int n = nums.size();
            int cur=0; int next=0; int jump=0;
            for(int i=0; i<n-1; i++){
                next = max(next, i+nums[i]);
                if(i==cur){
                    cur = next;
                    jump++;
                }
            }
            return jump;
        }
    };