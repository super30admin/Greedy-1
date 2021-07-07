//Time Complexity-O(n)
//Space Complexity-O(1)
//Did the code execute on Leetcode? Yes

class Solution {
public:
    bool canJump(vector<int>& nums) {
        if(nums.size()==0)
        {
            return true;
        }
        int dest=nums.size()-1;
        for(int i=nums.size()-2;i>=0;i--)
        {
            if(i+nums[i]>=dest)
            {
                dest=i;
            }
        }
        if(dest==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
};