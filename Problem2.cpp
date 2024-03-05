class Solution {

    //TC : O(N)
    //SC : O(1)
public:
    int jump(vector<int>& nums) {
       int totalJumps = 0;
        int destination = nums.size() - 1;
        int coverage = 0, lastJumpIdx = 0;

        // Base case
        if (nums.size() == 1) return 0;

        // Greedy strategy: extend coverage as long as possible
        for (int i = 0; i < nums.size(); i++) {
            coverage = std::max(coverage, i + nums[i]);

            if (i == lastJumpIdx) {
                lastJumpIdx = coverage;
                totalJumps++;

                // Check if we reached destination already
                if (coverage >= destination) {
                    return totalJumps;
                }
            }
        }

        return totalJumps;
    }
};