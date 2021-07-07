//Time Complexity-O(n)
//Space Complexity-O(1)
//Did the code execute on Leetcode? Yes

class Solution {
public:
    int jump(vector<int>& nums) {
        if(nums.size()==0|| nums.size()==1)
        {
            return 0;
        }
        int current=nums[0];
        int next=nums[0];
        int count=1;
        for(int i=1;i<nums.size();i++)
        {
            next=max(next,i+nums[i]);
            if(i<nums.size()-1 && i==current)
            {
                current=next;
                count++;
            }
        }
        return count;
    }
};