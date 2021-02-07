//Time - O(n)
//Space - O(1)
class Solution {
public:
    bool canJump(vector<int>& nums) {
        
        int dest = nums.size()-1, curr = nums.size()-2;
        while(curr>=0){
            if(nums[curr] + curr>=dest){
                dest = curr;
            }
            curr--;
        }
        
        return dest == 0;
    }
};