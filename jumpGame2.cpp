class Solution {
public:
    int jump(vector<int>& nums) {
        int maxInterval=0;
        int currMax=0;
        int jumps=0;
        
        for (int i=0;i<nums.size()-1;i++) {
            if (nums[i]+i>maxInterval) {
                maxInterval=nums[i]+i;
            }
            
            if (i==currMax) {
                jumps++;
                currMax=maxInterval;
            }
        }
        return jumps;
    }
};