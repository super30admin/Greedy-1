// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int jump(int[] nums) {
    	int jumps = 0, scope = 0, farthest = 0;
    	if(nums.length == 1) return 0;

    	for(int i = 0; i < nums.length; i++) {
    		farthest = Math.max(farthest, i + nums[i]);
    		if(farthest >= nums.length - 1) return jumps + 1;
    		if(i == scope) {
    			jumps++;
    			scope = farthest;
    		}
    	}

    	return jumps;
    }
}