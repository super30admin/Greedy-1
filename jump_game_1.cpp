//Time Complexity-O(n)
//Space Complexity-O(1)
//Ran successfully on leetcode

class Solution {
public:
    bool canJump(vector<int>& nums) {
        if(nums.empty())
            return false;
        int n=nums.size();
        int dest=n-1;
        for(int i=n-2;i>=0;i--)
        {
            if(i+nums[i]>=dest)
                dest=i;
        }
        return (dest==0);
    }
};