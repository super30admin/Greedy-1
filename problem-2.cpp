class Solution {
public:
    int jump(vector<int>& nums) {
        int farthest = 0, jumps = 0, current = 0, i, ln = nums.size();
        for(i = 0; i < ln - 1; i++){
            farthest = max(farthest, nums[i]+i);
            if(i == current) {
                current = farthest;
                jumps++;
            }
        }
        return jumps;
    }
};
