/*
Time complexity: O(n)
Space complexity: O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/

class Solution {
public:
int jump(vector<int>& nums) {
	int n = size(nums), i = 0, maxReachable = 0, lastJumpedPos = 0, jumps = 0;
	while(lastJumpedPos < n - 1) {
		maxReachable = max(maxReachable, i + nums[i]);
		if(i == lastJumpedPos) {
			lastJumpedPos = maxReachable; 
			jumps++;
		}            
		i++;
	}
	return jumps;
}
};