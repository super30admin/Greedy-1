//Time - O(n)
//Space - O(1)
class Solution {
public:
    int jump(vector<int>& nums) {
        int i = 0;
        if(nums.size()<=1) return 0;
        int jumps = 1, presentCover = nums[0]+i, nextCover = nums[0]+i;
        
        for(i = 1;i<nums.size()-1;i++){
            nextCover = max(nextCover, nums[i]+i);
            if(i == presentCover){
                jumps++;
                presentCover = nextCover;
            }
        }
        
        return jumps;
    }
};