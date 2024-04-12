class Solution {
public:
    bool canJump(vector<int>& nums) {
        int l=nums.size(),c=0,s=0;
        for(int i=0;i<l;i++)
        {
            s=max(s,nums[i]+i);
                if(i==c)
                    c=s; 
            if(c>=l-1)
                return true; 
        }
        return false;
    }
};
