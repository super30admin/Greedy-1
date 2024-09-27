//Time Complexity-O(n)
//Space Complexity-O(1)
//Ran successfully on leetcode

class Solution {
public:
    int jump(vector<int>& nums) {
        if(nums.empty())
            return -1;
        if(nums.size()==1)
            return 0;
        int curr=nums[0];
        int next=nums[0];
        int jump=1;
        for(int i=1;i<nums.size();i++)
        {
            next=max(next,i+nums[i]);
            if(i<nums.size()-1&&i==curr)
            {
                if(curr==next)
                    return -1;
                curr=next;
                jump++;
            }
        }
        return jump;
    }
};