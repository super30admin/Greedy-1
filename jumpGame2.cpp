// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Maintain two intervals, current and next. Current interval indicates the max location reachable starting from current interval start location.
 * Next interval, max location reachable in additional jump from current interval locations.
 * If current index is same as end of current interval then increment jumps. And set current interval to next interval.   
 */

class Solution {
public:
    int jump(vector<int>& nums) {
        if (nums.size() < 2)
        {
            return 0;
        }
        
        int jumps = 1;
        int curr_Interval = nums[0];
        int next_interval = nums[0];
        
        for (int i = 0; i < nums.size(); i++)
        {
            next_interval = max(next_interval, i + nums[i]);
            
            if (i < nums.size() - 1 && i == curr_Interval)
            {
                jumps++;
                curr_Interval = next_interval;
            }
        }
        return jumps;
    }
};