class Solution {
public:
    bool canJump(vector<int>& nums) {
        if (nums.size()<2) 
            return true;
        
        int destination=nums.size()-1;
        for (int i=destination;i>=0;i--) {
            if (i+nums[i]>=destination) {
                destination=i;
            }
        }
        return destination==0;
    }
};