//time: O(n)
//space: O(1)
class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        if(n == 1) return 0;
        int jumps = 1;
        int currInterval = nums[0];
        int nextInterval = nums[0];
        for(int i = 0; i < n; i++) {
            nextInterval = max(nextInterval, i + nums[i]);
            if(i == currInterval) {
                if(i != n-1) {
                    jumps++;
                }
                currInterval = nextInterval;
            }
        }
        return jumps;
    }
};
